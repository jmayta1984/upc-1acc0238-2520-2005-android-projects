package pe.edu.upc.easyshop.features.auth.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyshop.R
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.di.PresentationModule.getLoginViewModel
import pe.edu.upc.easyshop.features.auth.presentation.viewmodels.LoginViewModel

@Composable
fun Login(
    viewModel: LoginViewModel,
    onLogin: () -> Unit
) {

    val username by viewModel.username.collectAsState()

    val password by viewModel.password.collectAsState()

    val logged by viewModel.logged.collectAsState()

    val isVisible = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = {
                viewModel.updateUsername(it)
            },
            placeholder = {
                Text(text = stringResource(R.string.placeholder_email))
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            placeholder = {
                Text(text = stringResource(R.string.placeholder_password))
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        isVisible.value = !isVisible.value
                    }
                ) {
                    Icon(
                        if (isVisible.value) {
                            Icons.Default.Visibility
                        } else {
                            Icons.Default.VisibilityOff
                        },
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (isVisible.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        )

        Button(
            onClick = {
                viewModel.login()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text("Login")
        }

        if (logged) {
            Text("Successfull")
        }
    }
}

@Preview
@Composable
fun LoginPreview() {


    EasyShopTheme {
        Login(getLoginViewModel()) {

        }
    }

}