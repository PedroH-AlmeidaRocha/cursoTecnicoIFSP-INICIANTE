<?php

require_once "../classes/Editora.php";


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    
    $editora = new Editora();
    $editora->nome = $_POST["nome"];
    $editora->cidade = $_POST["cidade"];

    
    $editora->inserir();


    header("Location: listar.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Editora</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <header>
        <h1>Cadastro de editora</h1>
    </header>

    <div class="container2">
        <form method="post"> 
            <label>Nome da editora</label>
            <input type="text" name="nome" required>

            <label>Cidade</label>
            <input type="text" name="cidade" required>

            <button type="submit" name="btnSalvar">Enviar</button>
            <br><br>
          
       
        
      </form>
        <a href="../index.php" class="btn-voltar">
           <h3>Voltar</h3>  
           </a>    
    </div> 
</body>
</html>