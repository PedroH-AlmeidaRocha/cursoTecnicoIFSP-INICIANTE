<?php

require_once "../classes/Editora.php"; 

$id = $_GET["id"];

if($_SERVER["REQUEST_METHOD"] == "POST"){
    
  
    $editora = new Editora();

    $editora->id_editora = $id;
    
    $editora->nome = $_POST["nome"]; 
    $editora->cidade = $_POST["cidade"]; 

    
    $editora->editar();

    header("Location: listar.php");
    exit();
}


$dados = Editora::buscar($id);
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Editar Editora</title>
</head>
<body>

<header>
    <h1>Editar Editora</h1>
</header>

<div class="container2">
    <form method="post">
        <label>Nome da editora</label>
        <input type="text" name="nome" value="<?= $dados["nome"] ?>" required>

        <label>Cidade</label>
        <input type="text" name="cidade" value="<?= $dados["cidade"] ?>" required>
        
        <button type="submit">Salvar Alterações</button>
        <a href="listar.php">Cancelar</a>
    </form>
</div>

</body>
</html>