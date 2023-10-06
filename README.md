# bookgallery
A spring boot backend application following MVC structure (view part is a react application) implements CRUD Apis  

## Model
The backed application builds a simple model called `Book` for the book gallery project and it has 6 attributes: 

**`id`** :  book id for primary key  
**`name`** :  book's name <sub>(which shouldn't be null)</sub>   
**`author`** : book's author  
**`price`** : book's download price <sub>(default with 0.0 and should not be smaller than 0)</sub>  
**`intro`** : simple introduction of the book   
**`tag`** : book's label <sub>(one book could have multiple labels separated by `;`)</sub>  
**`cover`** : book's cover image <sub>(should be stored in AWS S3 but I just put some image [links](https://m.media-amazon.com/images/I/61y4XeiQLnL._AC_UF894,1000_QL80_.jpg) in it)</sub>  
**`content`** : book's content link <sub>(should be stored in AWS S3 either like: [The old man and the sea](https://www.arvindguptatoys.com/arvindgupta/oldmansea.pdf). But I just simply put the download link here</sub>  
<sub>like [The old man and the sea](https://www.aliceandbooks.com/book/download-link/626/1874),</sub> 
<sub>this downlink should be generated by the backend based on the pdf object stored on S3)</sub>  
**`downloads`** : book's download number <sub>(showing the popularity of books, top 4 would be shown on the gallery main page)<sub>

## APIs
The backed mainly offers these APIs for frontend:  

**`/book/add`** : a `POST` method adds a new book rows to the database, require a body with the `json` of new book's base information.  

**`/book/incrementDownloads/{id}`** : a `PUT` method increases the `downloads` number of a book by it's `id`, shoul be called after users download each time.  

**`/book/getAll`** : a `GET` method returns a `book` array `json` including all books from the database.  

**`/book/getBestsellers`** : a `GET` method returns the `book` array with top 4 download numbers.

**`/book/getById/{id}`** : a `GET` method return a `book`'s `json` by it's `id`.  
