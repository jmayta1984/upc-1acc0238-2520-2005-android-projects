package pe.edu.upc.superhero.features.heroes.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import pe.edu.upc.superhero.core.ui.components.HeroRow

@Preview(showBackground = true)
@Composable
fun SearchHeroView(
    modifier: Modifier = Modifier,
    viewModel: SearchHeroViewModel = hiltViewModel()
) {

    val query = viewModel.query.collectAsState()
    val heroes = viewModel.heroes.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 32.dp)
    ) {

        OutlinedTextField(
            value = query.value,
            onValueChange = {
                viewModel.onQueryChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Search")
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.searchHero()
                    }
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        )

        LazyColumn {
            items(heroes.value) { hero ->
                HeroRow(hero) {
                    viewModel.toggleFavorite(hero)
                }
            }
        }

    }
}