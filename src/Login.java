import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner dataUser = new Scanner(System.in);
        Boolean passwordValid = false, validLogin = false;
        String password = "";
        int countTries = 3;


        System.out.println("***Cadastro de Usuario***");
        System.out.println("---------------------------");
        System.out.println(" ");
        System.out.println("Digite seu primeiro nome: ");
        String firstName = dataUser.nextLine();
        System.out.println("Digite seu ultimo sobrenome: ");
        String lastName = dataUser.nextLine();
        String userName = firstName.toLowerCase().charAt(0) + "_" + lastName.toLowerCase();
        System.out.println("Seu nome de usuario e: \n*** "+userName+" ***\n");

        while (passwordValid == false) {
            System.out.println("Digite sua senha: ");
            password = dataUser.nextLine();
            if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[-, !, @, #, $, %, ?, &])(?=.*[A-Z])(?=.*\\d).+") && password.length() >= 8) {
                System.out.println("Senha dentro do padrao\n");
                passwordValid = true;
            } else {
                System.out.println("A senha tem que ter 8 caracteres contendo ao menos: 1 letra maiuscula, 1 numero e 1 caractere alfanumerico(ex: #, $, @)\n");
            }
        }
        System.out.println("(****--------Bem-vindo ao Sistema---------****)");
        while (validLogin==false) {
            System.out.println("Digite seu nome de usuario:");
            String login = dataUser.nextLine();
            System.out.print("Digite sua senha: \n");
            String senha = dataUser.nextLine();
            System.out.println(" ");
            if (login.equals(userName) && senha.equals(password)) {
                System.out.println("***********###########***********");
                System.out.println("Seja Bem vindo! " + userName+"\n");
                validLogin = true;
            } else if (countTries > 0) {
                System.out.printf("Usuario e/ou senha estao incorretos!\nVoce tem %d tentativas\n\n", countTries);
                countTries--;
            } else if (countTries == 0){
                System.out.println("Voce excedeu o numero de tentativas\n");
                System.out.println("(##-----------Bye-----------##)");
                break;
            }
        }
    }
}
