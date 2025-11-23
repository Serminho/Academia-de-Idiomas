public class Main {
    public static void main(String[] args) {

        CadastroCursos cadastroCursos = new CadastroCursos();
        MenuConsole menu = new MenuConsole(cadastroCursos);

        menu.iniciar();

    }
}
