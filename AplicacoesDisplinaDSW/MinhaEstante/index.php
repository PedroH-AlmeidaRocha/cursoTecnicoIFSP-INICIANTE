
<?php

require_once "livros.php";


if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $livro = new Livro();

    $livro->cadastrar(
        $_POST['titulo'],
        $_POST['autor'],
        $_POST['sinopse'],
        $_POST['genero'],
        $_POST['ano']
    );

    header("Location: livroCadastrados.php");
    exit();
}

?>




<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela inicial</title>
    <link rel="stylesheet" href="css/style.css" >
</head>
<body>
    
        <br>
        <h1 style="text-align: center;">Boas vindas à sua estante virtual</h1>    

  <div class="container">
    <form  method="post" action="index.php">     
       
        <label for="titulo">Digite o título do seu livro:</label>
        <input type="text" name="titulo" id="titulo" required>
        <br><br>

        <label for="autor">Digite o autor(a) do seu livro:</label>
        <input type="text"  name="autor" id="autor" value="" required>
        <br><br>

     
        <label for="sinopse">Digite a sinopse do seu livro:</label><br>
        <textarea id="sinopse" name="sinopse" required></textarea>
        <br><br>

        <label for="genero">Escolha o gênero literário:</label>
        <select name="genero" id="genero" required>
        <option value="" disabled selected>Selecione uma opção...</option>
        <option value="ficcao">Ficção</option>
        <option value="romance">Romance</option>
        <option value="terror">Terror</option>
        <option value="ciencia">Ciência</option>
        <option value="biografia">Biografia</option>
        <option value="literatura">Literatura</option>
        <option value="culinaria">Culinária</option>
        </select>
        <br><br>


        
         <label for="ano">Digite o ano de publicação do seu livro:</label>
         <input type="number" name="ano" id="ano" required>
        <br><br> 
        
        <button type="submit">Enviar</button> 
        <br><br>
        <a href="livroCadastrados.php">
        <h3>Clique aqui para ver livros cadastrados</h3>  
        </a>   


      
    </form>  
  </div> 
</body>
</html>