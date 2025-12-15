# J'ai Soif Montreal
_A website that displays an interactive map of public drinking fountains on the island of Montreal, Canada._

## Architecture

![Architectural Diagram](jai_soif_montreal_architecture.jpg)

I chose to build this application using a very corporate tech stack. Java Spring has been a popular backend web framework and scales very well which is why it's often used in a corporate setting. I chose to use a Postgresql database for my application instead of firebase or creating my own NoSQL database because SQL databases are popular in corporate settings and Postgresql is widely supported and open source. I chose to use Angular as the frontend framework as it is a popular corporate choice for applications due to its comrehensiveness.

## The Data

The data was taken taken from the [city of Montreal's Donees Ouverts site](https://donnees.montreal.ca/dataset/fontaines-a-boire-eau-exterieures). The data is simply downloadable as a .CSV file (frustratingly some other "public" datasets from the city of Montreal are not likely due to privacy reasons). The dataset con...

## How I handled localization

Montreal est une ville 
