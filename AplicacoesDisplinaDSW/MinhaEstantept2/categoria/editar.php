<?php

require_once "../classes/Categoria.php"; 

$id = $_GET["id"];

if($_SERVER["REQUEST_METHOD"] == "POST"){
    
    
    $categoria = new Categoria();

    $categoria->id_categoria = $id;
   
    $categoria->nome = $_POST["nome"]; 

    $categoria->editar();

    header("Location: listar.php");
    exit();
}


$dados = Categoria::buscar($id);
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Editar Categoria</title>
</head>
<body>

<header>
    <h1>Editar Categoria</h1>
</header>

<div class="container2">
    <form method="post">
        <label>Nome da categoria</label>
        <input type="text" name="nome" value="<?= $dados["nome"] ?>" required>
        
        <button type="submit">Salvar Alterações</button>
        <a href="listar.php">Cancelar</a>
    </form>
</div>

</body>
</html>