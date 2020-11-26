package com.example.cs5610fall2020projectteam23serverjava.models;

import java.io.Serializable;

public class FavoriteId implements Serializable {
    private Integer movieId;
    private Integer userId;

    public boolean equals(Object object) {
        if (object instanceof FavoriteId) {
            FavoriteId otherId = (FavoriteId) object;
            return (otherId.movieId.equals(this.movieId))
                    && (otherId.userId.equals(this.userId));
        }
        return false;
    }

    public FavoriteId() {
    }
    public FavoriteId(Integer movieId, Integer userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
