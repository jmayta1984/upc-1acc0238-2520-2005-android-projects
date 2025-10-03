package pe.edu.upc.superhero.features.heroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.superhero.features.heroes.domain.Hero
import pe.edu.upc.superhero.features.heroes.domain.HeroRepository
import javax.inject.Inject

@HiltViewModel
class SearchHeroViewModel @Inject constructor(private val repository: HeroRepository) :
    ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _heroes = MutableStateFlow<List<Hero>>(emptyList())
    val heroes: StateFlow<List<Hero>> = _heroes

    fun onQueryChange(value: String) {
        _query.value = value
    }

    fun searchHero() {
        viewModelScope.launch {
            _heroes.value = repository.searchHero(_query.value)
        }
    }

    fun toggleFavorite(hero: Hero) {

    }
}