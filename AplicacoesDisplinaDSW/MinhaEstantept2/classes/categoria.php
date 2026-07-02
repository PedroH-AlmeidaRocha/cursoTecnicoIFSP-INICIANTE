<?php

require_once "../conexao/Banco.php";

class Categoria{

    public $id_categoria;
    public $nome;

    public function inserir(){

        $sql = "INSERT INTO categoria(nome)
                VALUES(:nome)";

        $banco = new Banco();
        $conexao = $banco->conectar();

        $query = $conexao->prepare($sql);

        $query->bindValue(":nome", $this->nome);

        return $query->execute();
    }

    public static function listar(){

        $sql = "SELECT * FROM categoria ORDER BY id_categoria";

        $banco = new Banco();
        $conexao = $banco->conectar();

        return $conexao->query($sql);
    }

    public function editar(){

        $sql = "UPDATE categoria
                SET nome= :nome
                WHERE id_categoria = :id";

        $banco = new Banco();
        $conexao = $banco->conectar();

        $query = $conexao->prepare($sql);

        $query->bindValue(":nome", $this->nome);
        $query->bindValue(":id", $this->id_categoria);

        return $query->execute();
    }
    public static function buscar($id){

    $sql = "SELECT * FROM categoria
            WHERE id_categoria = :id";

    $banco = new Banco();
    $conexao = $banco->conectar();

    $query = $conexao->prepare($sql);

    $query->bindValue(":id", $id);

    $query->execute();

    return $query->fetch(PDO::FETCH_ASSOC);
}
}