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

**`/book/findByBookName/{name}`** : a `GET` method return a `book`'s `json` by it's precise name.  

**`/book/findByBookTag/{tag}`** : a `GET` method return a `book`'s `joson` which's label including the `{tag}`.

**`/book/deleteById/{id}`** : a `DELETE` method to drop the rows in database with the `id` as primary key.

**`/book/updateById/{id}`** : a `PUT` method to change a `book`'s database info by the `id`, require a `json` body.  
For any value's key matches the exact model attribute name in the `json` body <sub>(except `id`)</sub>, the vale would be update to the databse.  
For example, the book with `{id}`:8 in data base is like:
```
    {
        "id": 8,
        "price": 1.0,
        "name": "Demo Book",
        "author": "John Doe",
        "cover": "https://m.media-amazon.com/images/I/41vLer1KbmL.jpg",
        "tag": "Other",
        "intro": "Just a book.",
        "content": "https://www.aliceandbooks.com/book/download-link/626/1874",
        "downloads": 5
    },
```
and if I send this body to the server:
```
    {
        "id": 1,
        "name": "My book",
        "abc": 123,
        "version": "first edited",
        "author": "myself",
        "publisher": "xyz publisher"
    },
```
this row in the database would be updated to:
```
    {
        "id": 8,
        "price": 1.0,
        "name": "My book",
        "author": "myself",
        "cover": "https://m.media-amazon.com/images/I/41vLer1KbmL.jpg",
        "tag": "Other",
        "intro": "Just a book.",
        "content": "https://www.aliceandbooks.com/book/download-link/626/1874",
        "downloads": 5
    },
```

I want to implement the input filter in frontend, but not finish yet, and which would be implemnts later.



## How to test

The sql file is under the project `database` directory. I use mySQl as my database and Apache web server.  
The database name is `bookgallery` and the table name is `book`, database user name is `root` without setting any password.  
<sub>(which could be easily found in `application.properties` file and you could change the database configuration if you want)</sub>
Both with them could be provided by `XAMPP`, so I use XAMPP 8.2.4 to run my database and web server.  
![WeChat3b2c016e448cb13a33b0a49bc3a00641](https://github.com/LukeYu-RX78/bookgallery/assets/116868785/e0a7f1f7-f3c0-4710-bcaa-c33fe03240c2)  

After started the database and web server, just run the backend project

