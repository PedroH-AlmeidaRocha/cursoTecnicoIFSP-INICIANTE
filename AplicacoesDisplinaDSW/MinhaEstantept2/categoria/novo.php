<?php
require_once '../classes/Categoria.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $categoria = new Categoria();
    $categoria->nome = $_POST['nome']; 
    $categoria->inserir();
    
    header("Location: listar.php"); 
    exit();
}
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Cadastro de Categoria</title>
</head>
<body>

<header>
    <h1>Cadastro de Categoria</h1>
</header>

<div class="container2">

<form method="post">
    <label>Nome da categoria</label>
    <input type="text" name="nome" required>
    <button type="submit">Enviar</button>
</form>
    
      <a href="../index.php" class="btn-voltar">
        <h3>Voltar</h3>  
        </a>   

</div>

</body>
</html>