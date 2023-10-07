package it.fi.meucci;

public class App {
    public static void main( String[] args )
    {
        Client cliente = new Client();
        cliente.connetti();
        cliente.comunica();
    }
}
