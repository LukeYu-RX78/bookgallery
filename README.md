# bookgallery
A spring boot backend application following MVC structure (view part is a react application) implements CRUD Apis

## Model
The backed application builds a simple model called `Book` for the book gallery project and it has 6 attributes:  
`id`:  book id for primary key  
`name`:  book's name (which shouldn't be null)  
`author`: book's author  
`price`: book's download price (default with 0.0 and should not be smaller than 0)  
`intro`: simple introduction of the book   
`tag`: book's label (one book could have multiple labels separated by `;`)  
`cover`: book's cover image (should be stored in AWS S3 but I just put some image links in it)  
`content`: book's content link (should be stored in AWS S3 either like this [The old man and the sea](https://www.arvindguptatoys.com/arvindgupta/oldmansea.pdf).)
