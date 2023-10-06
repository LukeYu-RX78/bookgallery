# bookgallery
A spring boot backend application following MVC structure (view part is a react application) implements CRUD Apis

## Model
The backed application builds a simple model called `Book` for the book gallery project and it has 6 attributes:  
`id`:  book id for primary key  
`name`:  book's name <sub>(which shouldn't be null)</sub>   
`author`: book's author  
`price`: book's download price <sub>(default with 0.0 and should not be smaller than 0)</sub>  
`intro`: simple introduction of the book   
`tag`: book's label <sub>(one book could have multiple labels separated by `;`)</sub>  
`cover`: book's cover image <sub>(should be stored in AWS S3 but I just put some image [links](https://m.media-amazon.com/images/I/61y4XeiQLnL._AC_UF894,1000_QL80_.jpg) in it)</sub>  
`content`: book's content link <sub>(should be stored in AWS S3 either like: [The old man and the sea](https://www.arvindguptatoys.com/arvindgupta/oldmansea.pdf).</sub>  
<sub>But I just simply put the download link here like [The old man and the sea](https://www.aliceandbooks.com/book/download-link/626/1874),</sub> 
<sub>this downlink should be generated by the backend based on the pdf object stored on S3)</sub>  
`downloads`: book's download number, showing the popularity of the book <sub>(top 4 would be shown on the gallery main page)<sub>
