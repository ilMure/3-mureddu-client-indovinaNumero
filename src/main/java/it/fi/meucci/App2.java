package it.fi.meucci;

public class App2 {
    public static void main( String[] args )
    {
        Client cliente = new Client();
        cliente.connetti();
        cliente.comunica();
    }
}
