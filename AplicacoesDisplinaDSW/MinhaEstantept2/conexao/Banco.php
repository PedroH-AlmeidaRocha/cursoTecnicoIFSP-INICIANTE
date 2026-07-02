<?php
    class Banco{
        private $host = "localhost";
        private $porta = "5432";
        private $nome_banco = "MinhaEstante";
        private $usuario = "postgres";
        private $senha = "1234";

        public function conectar(){

            try{
                $conn = new PDO("pgsql:host=$this->host;port=$this->porta;dbname=$this->nome_banco",$this->usuario,$this->senha);
                return $conn;
              }
                catch(PDOException $e){
                echo "Erro de conexão com o banco";
             }
         }

    }

  




?>