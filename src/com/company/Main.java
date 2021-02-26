

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

class alunos {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    alunos() throws FileNotFoundException {
    }
//    public void adicionaSala() throws IOException {
//
//        {
//            PrintWriter pw = new PrintWriter(new BufferedWriter(new
//                    FileWriter("sala.txt")));
//            pw.close();
//
//        }
//        {
//            PrintWriter pw = new PrintWriter(new BufferedWriter(new
//                    FileWriter("lotacao.txt")));
//            pw.close();
//
//        }
//
//        String sala;
//        String nAlunos;
//
//
//            PrintWriter pw = new PrintWriter(new BufferedWriter(new
//                    FileWriter("sala.txt", true)));
//            System.out.print("\nInsira a quantidade de salas desejada: ");
//            sala = br.readLine();
//
//        pw.write(sala + "\n");
//        pw.flush();
//        pw.close();
//
//             PrintWriter pw2 = new PrintWriter(new BufferedWriter(new
//                FileWriter("lotacao.txt", true)));
//            System.out.print("\nInsira a lotação de cada sala: ");
//            nAlunos = br.readLine();
//
//            pw2.write(nAlunos + "\n");
//            pw2.flush();
//            pw2.close();
//
//            System.out.print("\nDados Gravados... \n");
//        mostrarMenu();
//
//
//
//    }

//    public void divideAlunosSalas() throws IOException {
//
//        BufferedReader br = new BufferedReader(new FileReader("sala.txt"));
//
//        String numSalas;
//        numSalas = br.readLine();
//        int numSalaInt = Integer.parseInt(numSalas);
//
//        BufferedReader br2 = new BufferedReader(new FileReader("lotacao.txt"));
//
//        String lotacao;
//
//        lotacao = br2.readLine();
//        int lotacaoInt = Integer.parseInt(lotacao);
//
//
//        BufferedReader br3 = new BufferedReader(new FileReader("alunos.txt"));
//        long alunos = Files.lines(Paths.get("alunos.txt")).count();
//
//
//        System.out.println("Numero de alunos= " + alunos);
//        System.out.println("Númeo de salas= " + numSalaInt);
//        System.out.println("Lotação por sala= " + lotacaoInt);
//
//        br.close();
//        br2.close();
//        br3.close();
//
//        if ( alunos %  numSalaInt > lotacaoInt){
//            System.out.println("Valor inválido || Número de alunos é maior que lotação. ");
//
//        }else {
//            PrintWriter pw = new PrintWriter(new BufferedWriter(new
//                    FileWriter("alunos.txt", true)));
//            int sala = 1;
//            pw.write(sala + "," + "\n");
//
//            pw.close();
//        }
//        mostrarMenu();
//
//    }


    public void adicionaDados() throws IOException {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new
                FileWriter("alunos.txt", true)));

        String nomeAluno;
        String sala;
        String s;
        boolean addMore = false;

        do {
            System.out.print("\nInsira o nome do Aluno: ");
            nomeAluno = br.readLine();

            System.out.print("\nInsira a sala do Aluno: ");
            sala = br.readLine();

            pw.write(sala.toLowerCase(Locale.ROOT) + "," + nomeAluno.toUpperCase() + "\n");
            pw.flush();


            System.out.print("\nDados Gravados... \n\nVocê gostaria de gravar mais dados? (s/n) : ");
            s = br.readLine();

            if (s.equalsIgnoreCase("s")) {
                addMore = true;
                System.out.println();
            } else
                addMore = false;
        }
        while (addMore);
        pw.close();

        mostrarMenu();
    }

    public void leDados() throws IOException{

    BufferedReader br = new BufferedReader(new FileReader("alunos.txt"));

    String record;

    	System.out.println(" ----------------------------------------- ");
    	System.out.println("|	Sala		    Nome	              |");
    	System.out.println(" ----------------------------------------- ");

    	while((record =br.readLine())!=null)

    {

        StringTokenizer st = new StringTokenizer(record, ",");

        System.out.println("|	" + st.nextToken() + " 	" + st.nextToken() );

    }

    	System.out.println("|	                           	           ");
    	System.out.println(" ----------------------------------------- ");
    	br.close();

        mostrarMenu();
}
    public void leDadosSala() throws IOException {
        String resposta, sala;
        Scanner strInput = new Scanner(System.in);

        BufferedReader br = new BufferedReader( new FileReader("alunos.txt") );


        System.out.println(" Digite a sala desejada ");
        sala = strInput.nextLine();

        System.out.println(" ----------------------------------------- ");
        System.out.println("|	Sala          Nome	                   ");
        System.out.println(" ----------------------------------------- ");

        while( ( resposta = br.readLine() ) != null ) {

            StringTokenizer st = new StringTokenizer(resposta,",");
            if( resposta.contains(sala.toLowerCase(Locale.ROOT)) ) {
                System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+"      ");
            }



        }

        System.out.println("|	                                       ");
        System.out.println(" ----------------------------------------- ");

        br.close();
        mostrarMenu();



    }
    public void apagar() throws IOException
    {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new
                FileWriter("alunos.txt")));
        pw.close();
        System.out.println("\nDados apagados");

        mostrarMenu();
    }
    public void mostrarMenu() throws IOException
    {
        System.out.print("1 : Inserir Alunos\n2 : Mostrar Alunos\n" +
                "3 : Apagar Todos os Dados\n4 : Mostrar Sala \n" +
//                "5 : Adiciona Sala\n6 : Divide Alunos em Salas " +
                "\n5 : Sair \nSua Escolha : ");
        int choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
            case 1:
                adicionaDados();
                break;
            case 2:
                leDados();
                break;
            case 3:
                apagar();
                break;
            case 4:
               leDadosSala();
                break;
            case 5:
                System.exit(1);
                break;
//            case 5:
//                adicionaSala();
//                break;
//            case 6:
//                divideAlunosSalas();
//                case 7:
//                System.exit(1);
//                break;

            default:
                System.out.println("\nEscolha inválida ");
                break;
        }
    }
    public static void main(String args[]) throws IOException
    {
        alunos call = new alunos();
        call.mostrarMenu();
    }
}