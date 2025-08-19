package com.saiapp.sparkit.model

import android.content.Context
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.saiapp.sparkit.ktorClient.LoginViewModel
import com.saiapp.sparkit.view.handleFailure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private const val TAG: String = "GoogleAuth"

object GoogleAuth {
    suspend fun launchSignIn(
        context: Any?,
        serverClientId: String,
        loginViewModel: LoginViewModel,
        coroutineScope: CoroutineScope,
    ) {
        try {
            val credentialManager = CredentialManager.create(context as Context)
            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(serverClientId = serverClientId)
                .setAutoSelectEnabled(true)
                .build()


            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialManager.getCredential(
                request = request,
                context = context,
            )
            handleSignIn(result, loginViewModel, coroutineScope)
        } catch (e: GetCredentialException) {
            handleFailure(e)
        }
    }

    private fun handleSignIn(
        result: GetCredentialResponse,
        loginViewModel: LoginViewModel,
        coroutineScope: CoroutineScope
    ) {
        when (val credential = result.credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)
                        Log.d(TAG, googleIdTokenCredential.id)
                        Log.d(TAG, googleIdTokenCredential.idToken)

                        coroutineScope.launch {
                            try {
                                loginViewModel.getLoginDetails(autToken = googleIdTokenCredential.idToken)
                            } catch (e: Exception) {
                                Log.e(TAG, "Login Response Error :${e.message}")
                            }

                        }

                    } catch (e: GoogleIdTokenParsingException) {
                        Log.e(TAG, "Received an invalid google id token response", e)
                    }
                } else {
                    Log.e(TAG, "Unexpected type of credential")
                }
            }

            else -> {
                Log.e(TAG, "Unexpected type of credential")
            }
        }
    }
}