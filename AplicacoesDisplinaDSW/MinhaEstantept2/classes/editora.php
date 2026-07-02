<?php

require_once "../conexao/Banco.php";

class Editora{

    public $id_editora;
    public $nome;
    public $cidade;

    public function inserir(){

        $sql = "INSERT INTO editora(nome, cidade)
                VALUES(:nome, :cidade)";

        $banco = new Banco();
        $conexao = $banco->conectar();

        $query = $conexao->prepare($sql);

        $query->bindValue(":nome", $this->nome);
        $query->bindValue(":cidade", $this->cidade);

        return $query->execute();
    }

    public static function listar(){

        $sql = "SELECT * FROM editora ORDER BY id_editora";

        $banco = new Banco();
        $conexao = $banco->conectar();

        return $conexao->query($sql);
    }

public function editar(){

        $sql = "UPDATE editora
                SET nome = :nome, cidade = :cidade
                WHERE id_editora = :id";

        $banco = new Banco();
        $conexao = $banco->conectar();

        $query = $conexao->prepare($sql);

        $query->bindValue(":nome", $this->nome); 
        $query->bindValue(":cidade", $this->cidade);
        $query->bindValue(":id", $this->id_editora);

        return $query->execute();
    }
        public static function buscar($id){

            $sql = "SELECT * FROM editora
                    WHERE id_editora = :id";

                $banco = new Banco();
                $conexao = $banco->conectar();

                $query = $conexao->prepare($sql);

                $query->bindValue(":id", $id);

                $query->execute();

                return $query->fetch(PDO::FETCH_ASSOC);
            }
}