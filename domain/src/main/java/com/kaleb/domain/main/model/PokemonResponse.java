package com.kaleb.domain.main.model;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version PokemonResponse, v 0.1 13/03/19 11.22 by Billy Kaleb Hananto
 */
public class PokemonResponse {

    private String pokemonFrontLookSprite;

    private int pokemonHeight;

    private int pokemonId;

    private String pokemonName;

    private int pokemonWeight;

    public String getPokemonFrontLookSprite() {
        return pokemonFrontLookSprite;
    }

    public void setPokemonFrontLookSprite(String pokemonFrontLookSprite) {
        this.pokemonFrontLookSprite = pokemonFrontLookSprite;
    }

    public int getPokemonHeight() {
        return pokemonHeight;
    }

    public void setPokemonHeight(int pokemonHeight) {
        this.pokemonHeight = pokemonHeight;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getPokemonWeight() {
        return pokemonWeight;
    }

    public void setPokemonWeight(int pokemonWeight) {
        this.pokemonWeight = pokemonWeight;
    }
}
