
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Agendamento {
    private String id = "";
    private String prof = "";
    private String status = "Pendente";
    private LocalDateTime dataehora = null;
    private String curso = "";
    private double valor = (double)10000.0F;

    public void fazerAgendamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|--------------------------------------|");
        System.out.println("|=-=-=-= SISTEMA DE AGENDAMENTO =-=-=-=|");
        System.out.println("|=-=-=-=-= AULAS PARTICULARES =-=-=-=-=|");
        System.out.println("|--------------------------------------|");
        System.out.println("| Qual o curso que você deseja agendar?|");
        System.out.println("|                                      |");
        System.out.println("|1- Inglês -> Prof. João Paulo         |");
        System.out.println("|2- Espanhol -> Prof. Samuel           |");
        System.out.println("|3- Francês -> Prof. Absalão           |");
        System.out.println("|4- Italiano -> Prof. Daniel           |");
        System.out.println("|--------------------------------------|");
        System.out.println("|OBS: Todas as opções que você desejar |");
        System.out.println("|durante o programa, coloque o número  |");
        System.out.println("|correspondente a sua escolha!         |");
        int op = scanner.nextInt();
        scanner.nextLine();
        String cursoSelecionado = "";
        String professorSelecionado = "";
        switch (op) {
            case 1:
                cursoSelecionado = "Inglês";
                professorSelecionado = "Prof. João Paulo";
                break;
            case 2:
                cursoSelecionado = "Espanhol";
                professorSelecionado = "Prof. Samuel";
                break;
            case 3:
                cursoSelecionado = "Francês";
                professorSelecionado = "Prof. Absalão";
                break;
            case 4:
                cursoSelecionado = "Italiano";
                professorSelecionado = "Prof. Daniel";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.println("|----------------------------------------|");
        System.out.println("|-=-=-= " + cursoSelecionado + " -> " + professorSelecionado + " =-=-=-|");
        System.out.println("|=-=-=-=-= Horários Disponíveis =-=-=-=-=|");
        System.out.println("|----------------------------------------|");
        System.out.println("| Turno Manhã:                           |");
        System.out.println("| 1- 8:00 ás 9:40 | 2- 10:00 ás 11:40    |");
        System.out.println("|////////////////////////////////////////|");
        System.out.println("| Turno Tarde:                           |");
        System.out.println("| 3- 14:00 ás 15:40 | 4- 16:00 ás 17:40  |");
        System.out.println("|////////////////////////////////////////|");
        System.out.println("| Turno Noite:                           |");
        System.out.println("| 5- 18:00 ás 19:40 | 6- 20:00 ás 21:40  |");
        System.out.println("|////////////////////////////////////////|");
        System.out.println("|Cada horário possui um valor simbólico  |");
        System.out.println("|de 10000 reais.                         |");
        System.out.println("|Qual horário você quer agendar?         |");
        int opturno = scanner.nextInt();
        scanner.nextLine();
        String horarioSelecionado = "";
        LocalTime horaInicio = null;
        switch (opturno) {
            case 1:
                horarioSelecionado = "8:00-9:40";
                horaInicio = LocalTime.of(8, 0);
                break;
            case 2:
                horarioSelecionado = "10:00-11:40";
                horaInicio = LocalTime.of(10, 0);
                break;
            case 3:
                horarioSelecionado = "14:00-15:40";
                horaInicio = LocalTime.of(14, 0);
                break;
            case 4:
                horarioSelecionado = "16:00-17:40";
                horaInicio = LocalTime.of(16, 0);
                break;
            case 5:
                horarioSelecionado = "18:00-19:40";
                horaInicio = LocalTime.of(18, 0);
                break;
            case 6:
                horarioSelecionado = "20:00-21:40";
                horaInicio = LocalTime.of(20, 0);
                break;
            default:
                System.out.println("Horário inválido!");
                return;
        }

        LocalDate dataAula = this.selecionarDataAula(scanner);
        if (dataAula == null) {
            System.out.println("Agendamento cancelado.");
        } else {
            LocalDateTime dataHoraAula = LocalDateTime.of(dataAula, horaInicio);
            if (dataHoraAula.isBefore(LocalDateTime.now())) {
                System.out.println("Não é possível agendar para datas passadas!");
            } else {
                this.curso = cursoSelecionado;
                this.prof = professorSelecionado;
                this.dataehora = dataHoraAula;
                this.status = "Agendado";
                this.id = "AG" + System.currentTimeMillis();
                System.out.println("|----------------------------------------|");
                System.out.println("|         AGENDAMENTO CONCLUÍDO!         |");
                System.out.println("|----------------------------------------|");
                System.out.println("| Curso: " + cursoSelecionado);
                System.out.println("| Professor: " + professorSelecionado);
                System.out.println("| Data: " + dataAula.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("| Horário: " + horarioSelecionado);
                System.out.println("| ID do Agendamento: " + this.id);
                PrintStream var10000 = System.out;
                Object[] var10002 = new Object[]{this.valor};
                var10000.println("| Valor: R$ " + String.format("%.2f", var10002));
                System.out.println("|----------------------------------------|");
                this.mostrarTempoRestante();
            }
        }
    }

    private LocalDate selecionarDataAula(Scanner scanner) {
        System.out.println("|----------------------------------------|");
        System.out.println("|         SELEÇÃO DE DATA               |");
        System.out.println("|----------------------------------------|");
        System.out.println("| As aulas acontecem apenas às:         |");
        System.out.println("| Segundas, Quartas e Sextas            |");
        System.out.println("|----------------------------------------|");
        System.out.println("| Digite a data (dd/MM/yyyy):           |");
        String dataInput = scanner.nextLine();

        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataInput, formato);
            DayOfWeek diaSemana = data.getDayOfWeek();
            if (diaSemana != DayOfWeek.MONDAY && diaSemana != DayOfWeek.WEDNESDAY && diaSemana != DayOfWeek.FRIDAY) {
                System.out.println("Erro: Aulas só acontecem às segundas, quartas e sextas!");
                return null;
            } else {
                return data;
            }
        } catch (Exception var6) {
            System.out.println("Data inválida! Use o formato dd/MM/yyyy");
            return null;
        }
    }

    public void mostrarTempoRestante() {
        if (this.dataehora == null) {
            System.out.println("Nenhum agendamento ativo.");
        } else {
            LocalDateTime agora = LocalDateTime.now();
            if (this.dataehora.isBefore(agora)) {
                System.out.println("⏰ Esta aula já aconteceu!");
            } else if (this.dataehora.isEqual(agora)) {
                System.out.println("\ud83c\udf89 A aula é agora!");
            } else {
                long diasRestantes = ChronoUnit.DAYS.between(agora.toLocalDate(), this.dataehora.toLocalDate());
                long horasRestantes = ChronoUnit.HOURS.between(agora, this.dataehora);
                System.out.println("Tempo até a aula:");
                System.out.println(diasRestantes + " dias");
                System.out.println(horasRestantes + " horas");
                if (horasRestantes <= 24L) {
                    System.out.println("⚠️  ATENÇÃO: Cancelamento com menos de 24h terá multa de 50%!");
                }

            }
        }
    }

    public void cancelarAgendamento() {
        if (this.dataehora != null && this.status.equals("Agendado")) {
            LocalDateTime agora = LocalDateTime.now();
            long horasRestantes = ChronoUnit.HOURS.between(agora, this.dataehora);
            System.out.println("|----------------------------------------|");
            System.out.println("|         CANCELAMENTO DE AULA          |");
            System.out.println("|----------------------------------------|");
            System.out.println("| Curso: " + this.curso);
            System.out.println("| Professor: " + this.prof);
            LocalDateTime var10001 = this.dataehora;
            System.out.println("| Data: " + var10001.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            System.out.println("| Horas restantes: " + horasRestantes + "h");
            if (horasRestantes < 24L) {
                double multa = this.valor * (double)0.5F;
                System.out.println("|----------------------------------------|");
                System.out.println("|⚠️  CANCELAMENTO COM MENOS DE 24H!      |");
                PrintStream var10000 = System.out;
                Object[] var10002 = new Object[]{multa};
                var10000.println("| Valor da multa: R$ " + String.format("%.2f", var10002));
                System.out.println("| Será cobrado 50% do valor da aula.    |");
                System.out.println("|----------------------------------------|");
            } else {
                System.out.println("|----------------------------------------|");
                System.out.println("|✅ Cancelamento sem multa aplicada.     |");
                System.out.println("|----------------------------------------|");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Confirmar cancelamento? (S/N)");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                this.status = "Cancelado";
                System.out.println("✅ Agendamento cancelado com sucesso!");
            } else {
                System.out.println("Cancelamento não confirmado.");
            }

        } else {
            System.out.println("Nenhum agendamento ativo para cancelar.");
        }
    }

    public void mostrarDetalhes() {
        System.out.println("|----------------------------------------|");
        System.out.println("|         DETALHES DO AGENDAMENTO       |");
        System.out.println("|----------------------------------------|");
        System.out.println("| ID: " + this.id);
        System.out.println("| Curso: " + this.curso);
        System.out.println("| Professor: " + this.prof);
        if (this.dataehora != null) {
            LocalDateTime var10001 = this.dataehora;
            System.out.println("| Data: " + var10001.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        }

        System.out.println("| Status: " + this.status);
        PrintStream var10000 = System.out;
        Object[] var10002 = new Object[]{this.valor};
        var10000.println("| Valor: R$ " + String.format("%.2f", var10002));
        System.out.println("|----------------------------------------|");
    }
}
