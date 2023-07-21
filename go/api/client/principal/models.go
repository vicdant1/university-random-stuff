package principal

type CreateMovieDto struct {
	ImdbID           string
	Title            string
	Year             string
	Released         string
	Genre            string
	Director         string
	Plot             string
	ImdbRating       string
	Type             string
	TomatoRating     string
	TomatoUserRating string
}

type MovieDto struct {
	ID               string `json:"id"`
	ImdbID           string `json:"imdbid"`
	Title            string `json:"title"`
	Year             string `json:"year"`
	Released         string `json:"released"`
	Genre            string `json:"genre"`
	Director         string `json:"director"`
	Plot             string `json:"plot"`
	Poster           string `json:"poster"`
	ImdbRating       string `json:"rating_imdb"`
	Type             string `json:"type"`
	TomatoRating     string `json:"rating_tomatoes"`
	TomatoUserRating string `json:"user_rating_tomatoes"`
	Response         string `json:"response"`
	Error            string `json:"error"`
}
