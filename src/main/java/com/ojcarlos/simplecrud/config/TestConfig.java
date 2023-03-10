package com.ojcarlos.simplecrud.config;

import com.ojcarlos.simplecrud.entities.*;
import com.ojcarlos.simplecrud.entities.enums.OrderStatus;
import com.ojcarlos.simplecrud.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Question1Repository question1Repository;

    @Autowired
    private Question2Repository question2Repository;

    @Autowired
    private Question3Repository question3Repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));



        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));



        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);



        Question1 q11 = new Question1(null,
                "Qual risco est?? relacionado ?? possibilidade de ocorr??ncia de danos, seja dentro de um\n" +
                        "per??odo pequeno ou grande de tempo com os preju??zos sendo causados por fatores de\n" +
                        "ordem natural, social ou tecnol??gica?",
                null,
                null,
                null,
                null,
                "Trata-se do Risco Ambiental."
        );
        Question1 q12 = new Question1(null,
                "O que vem a ser risco natural?",
                null,
                null,
                null,
                null,
                "O risco natural ?? a denomina????o que faz refer??ncia ??queles riscos que\n" +
                        "n??o podem ser facilmente atribu??dos ou relacion??veis ?? a????o humana, tais quais:\n" +
                        "riscos tect??nicos e magm??ticos; riscos e os riscos hidrol??gicos."
        );
        Question1 q13 = new Question1(
                null,
                "Quais dos seguintes elementos n??o est?? relacionado ao risco tecnol??gico",
                "A) Processo de trabalho (rela????es entre dire????es empresariais e estatais e assalariados)",
                "B) Per??odo de tempo, pequeno ou grande, no qual pode ocorrer a possibilidade de danos",
                "C) Processo de produ????o (recursos, t??cnicas, equipamentos, maquin??rio)",
                null,
                "Letra B"
        );

        Question2 q21 = new Question2 (
                null,
                "Dentre os riscos sociais, existem aqueles classificados como riscos end??genos. O que vem a ser risco end??geno?",
                "Riscos relacionados ?? administra????o adotada, como crescimento urbano e industrializa????o;",
                "Riscos relacionados ?? administra????o adotada, como crescimento urbano e industrializa????o",
                "Risco relacionado ao processo de produ????o (recursos, t??cnicas, equipamentos, maquin??rio)",
                null,
                "A"
        );

        Question2 q22 = new Question2(
                null,
                "5. Dentre os riscos sociais, existem aqueles classificados como riscos ex??genos. O que vem a ser um risco ex??geno?",
                "A) Risco que est?? relacionado a um per??odo, seja um per??odo pequeno ou grande",
                "B) Riscos relacionados ?? administra????o adotada, como crescimento urbano e industrializa????o;",
                "C) Riscos relacionados a amea??as externas como: terremotos, epidemias, secas e inunda????es;",
                null,
                "B"

        );
        Question2 q23 = new Question2(
                null,
                "Qual a diferen??a entre riscos e impactos ambientais?",
                null,null,null,null,
                "Risco ambiental remete ?? possibilidade de ocorr??ncia de eventos danosos ao ambiente, enquanto que, a no????o de impacto ambiental est?? ligada ?? repeti????o de algo que j?? aconteceu e que poder?? significar um evento positivo ou negativo, podendo comprometer a licen??a para instalar um empreendimento em determinado local."
        );

        Question3 q31 = new Question3(
                null,
                "Os m??todos de Avalia????o de Impacto Ambiental servem de refer??ncia nos estudos ambientais para determinar de forma mais precisa e significativa um impacto ambiental. Modelos matem??ticos destinados a representar o comportamento dos par??metros ambientais ou das rela????es de causa e efeito de determinadas a????es, refere-se ao conceito do m??todo:",
                "A) M??todos de Simula????o.",
                "B) Redes de Intera????o.",
                "C) Metodologias Quantitativas.",
                null,
                "A"
        );

        Question3 q32 = new Question3(
          null,
          "Os m??todos de Avalia????o de Impacto Ambiental servem de refer??ncia nos estudos ambientais para determinar de forma mais precisa e significativa um impacto ambiental. Dentre os m??todos, o que vem a ser as redes de intera????o?",
           null,null,null,null,
           "As redes t??m por objetivo as rela????es preced??ncia entre a????es praticadas pelo empreendimento e os consequentes impactos de primeira e demais ordens. Apresentam como vantagens o fato de permitirem uma boa visualiza????o de impactos secund??rios e demais ordens."
        );

        Question3 q33 = new Question3(
                null,
                "Em rela????o ao Estudo de Impacto Ambiental (EIA), diga qual ?? a alternativa incorreta:",
                "O EIA ?? o estudo das prov??veis modifica????es nas diversas caracter??sticas socioecon??micas e biof??sicas do meio ambiente que podem resultar de um projeto proposto, estabelecendo medidas de preven????o, mitiga????o e monitoramento dos danos ambientais.",
                "Para que o EIA seja juridicamente v??lido, a Resolu????o do CONAMA n?? 01/86 exige que sejam observados alguns requisitos, como a identifica????o de impactos ambientais gerados nas fases de implanta????o.",
                "O EIA ?? um resumo do Relat??rio de Impacto Ambiental (RIMA) e deve conter todas as informa????es inclu??das naquele, de forma resumida, simplificada e acess??vel.",
                null,
                "C"
        );

        Question1 q14 = new Question1(
                null,
                "Em setembro de 2015, a ONU (Organiza????o das Na????es Unidas) definiu objetivos de desenvolvimento sustent??vel (ODS), que devem ser implantados por todos os pa??ses do mundo at?? 2030. Quantos objetivos s??o?",
                null, null,null,null,
                "17"
        );

        Question1 q15 = new Question1(
                null,
                "Segundo os ODS (objetivos de desenvolvimento sustent??vel), que todos os pa??ses devem implantar at?? 2030, qual das alternativas abaixo n??o apresenta objetivos de desenvolvimento sustent??vel?",
                "Erradica????o da pobreza; Fome zero e agricultura sustent??vel; Sa??de e bem-estar; Energia Limpa e Acess??vel",
                "Educa????o de qualidade; Igualdade de g??nero; ??gua Pot??vel e Saneamento; Consumo e produ????o respons??veis;",
                "Sal??rios Justos; Liberdade de escolha; Acesso a informa????o; Direitos sociais e pol??ticos;",
                null,
                "C"
        );

        Question1 q16 = new Question1(
                null,
                "Sal??rios Justos; Liberdade de escolha; Acesso a informa????o; Direitos sociais e pol??ticos;",
                null, null,null,null,
                "S??o a????es para acabar com a pobreza, proteger o meio ambiente e o clima e garantir que as pessoas, em todos os lugares, possam desfrutar de paz e de prosperidade, definidos pelo ONU, devem ser implementados at?? 2030."
                );
        Question2 q24 = new Question2(
                null,
                "Sobre os objetivos de desenvolvimento sustent??vel, qual alternativa n??o descreve um dos objetivos da Erradica????o da Pobreza?",
                "At?? 2030, acabar com a fome e garantir o acesso de todas as pessoas, em particular os pobres e pessoas em situa????es vulner??veis, incluindo crian??as, a alimentos seguros, nutritivos e suficientes durante todo o ano.",
                "At?? 2030, erradicar a pobreza extrema para todas as pessoas em todos os lugares, atualmente medida como pessoas vivendo com menos de US$ 1,90 por dia.",
                "",
                "",
                "A"
        );

        Question2 q25 = new Question2(
                null,
                "Sobre os objetivos de desenvolvimento sustent??vel, qual alternativa n??o descreve um dos objetivos da ??gua Pot??vel e Saneamento?",
                "At?? 2030, alcan??ar o acesso universal e equitativo a ??gua pot??vel e segura para todos.",
                "At?? 2030, implementar a gest??o integrada dos recursos h??dricos em todos os n??veis, inclusive via coopera????o transfronteiri??a, conforme apropriado.",
                "Minimizar e enfrentar os impactos da acidifica????o dos oceanos, inclusive por meio do refor??o da coopera????o cient??fica em todos os n??veis.",
                null,
                "C"
                );

        Question2 q26 = new Question2(
                null,
                "Aumentar a urbaniza????o inclusiva e sustent??vel, e as capacidades para o planejamento e gest??o de assentamentos humanos participativos, integrados e sustent??veis, em todos os pa??ses, ?? um objetivo espec??fico de:",
                "Consumo e produ????o respons??veis;",
                "Cidades e comunidades sustent??veis;",
                "Ind??stria, inova????o e infraestrutura;",
                null,
                "B"

        );

        Question3 q34 = new Question3(
                null,
                "cabar com as epidemias de AIDS, tuberculose, mal??ria e doen??as tropicais negligenciadas, e combater a hepatite, doen??as transmitidas pela ??gua, e outras doen??as transmiss??veis, ?? um objetivo espec??fico de:",
                "??gua pot??vel e saneamento;",
                "Ind??stria, inova????o e infraestrutura;",
                "Sa??de e Bem-Estar;",
                null,
                "C"
        );
        Question3 q35 = new Question3(
               null,
               "Qual das alternativas abaixo ?? um objetivo espec??fico da Igualdade de g??nero?\n",
               "At?? 2030, alcan??ar o emprego pleno e produtivo e trabalho decente para todas as mulheres e homens, inclusive para os jovens e as pessoas com defici??ncia, e remunera????o igual para trabalho de igual valor.",
               "Garantir a participa????o plena e efetiva das mulheres e a igualdade de oportunidades para a lideran??a em todos os n??veis de tomada de decis??o na vida pol??tica, econ??mica e p??blica.",
               "At?? 2020, reduzir substancialmente a propor????o de jovens sem emprego, educa????o ou forma????o.",
               null,
               "B"
        );

        Question3 q36 = new Question3(
                null,
                "Cite tr??s ODS (objetivos de desenvolvimento sustent??vel) definidos pela ONU, em 2015.",
                null, null,null,null,
                "Erradica????o da pobreza, fome zero e agricultura sustent??vel, sa??de e bem-estar, educa????o de qualidade, igualdade de g??nero, ??gua pot??vel e saneamento, energia limpa e acess??vel, trabalho decente e crescimento econ??mico, ind??stria inova????o e infraestrutura, redu????o das desigualdades, cidades e comunidades sustent??veis, consumo e produ????o respons??veis, a????o contra a mudan??a global do clima, vida na ??gua, vida terrestre, paz justi??a e institui????es eficazes, parcerias e meios de implementa????o."

                );

        Question1 q17 = new Question1(
                null,
                "O que ?? o SISNAMA?",
                null, null,null,null,
                "R: Sistema Nacional do Meio Ambiente\n"

                );
        Question1 q18 = new Question1(
                null,
                "2. Em que ano o SISNAMA foi Criado?",
                null, null,null,null,
                ""

        );
        Question1 q19 = new Question1(
                null,
                "3. Qual a fun????o do CONAMA?\n",
                null, null,null,null,
                "assessorar, estudar e propor ao Conselho de Governo e demais ??rg??os ambientais diretrizes e pol??ticas governamentais para o meio ambiente e deliberar, no ??mbito de suas compet??ncias, sobre normas e padr??es para o meio ambiente."

        );

        Question2 q27 = new Question2(
                null,
                "O que significa a sigla CONAMA?",
                null,null,null,null,
                "R: Conselho Nacional do Meio Ambiente"
        );

        Question2 q28 = new Question2(
                null,
                "Assinale a alternativa que indica corretamente a sigla da estrutura adotada para a gest??o ambiental no Brasil, formada pelos ??rg??os e entidades da Uni??o, dos Estados, do Distrito Federal e dos Munic??pios respons??veis pela prote????o, melhoria e recupera????o da qualidade ambiental no Brasil, criada pela Lei 6.938/1981 e regulamentada pelo Decreto 99274/1990.",
                "FATMA",
                "FEPAM",
                "CONAMA",
                "SISNAMA",
                "D"
        );
        Question2 q29 = new Question2(
                null,
                "De acordo com a Lei Nacional que institui o Sistema Nacional do Meio Ambiente (SISNAMA), que previu as compet??ncias do Conselho Nacional do Meio Ambiente (CONAMA), ?? correto inferir que se inseri dentro do conceito de preserva????o, melhoria e recupera????o da qualidade ambiental, previstos na Lei de Pol??tica Nacional do Meio Ambiente (Lei n??  6.938/1981)",
                "A????o governamental na manuten????o do equil??brio ecol??gico, considerando o meio ambiente como um patrim??nio p??blico a ser necessariamente assegurado e protegido, tendo em vista o uso coletivo.",
                "Controle irrestrito do uso do solo, do subsolo, da ??gua e do ar, com limita????o para seu uso.",
                "",
                "",
                "A"
        );

        Question3 q37 = new Question3(
                null,
                "Sobre a Lei n?? 6.938, de 1981 e suas altera????es, que disp??e sobre a Pol??tica Nacional do Meio Ambiente, seus fins e mecanismos de formula????o e aplica????o, e d?? outras provid??ncias, ?? CORRETO afirmar que:\n",
                "Os ??rg??os e entidades da Uni??o, dos Estados, do Distrito Federal, dos Territ??rios e dos Munic??pios, bem como as funda????es institu??das pelo Poder P??blico, respons??veis pela prote????o e melhoria da qualidade ambiental, constituir??o o Conselho Nacional do Meio Ambiente (CONAMA)",
                "O Sistema Nacional do Meio Ambiente ??? SISNAMA ?? ??rg??o consultivo e deliberativo com a finalidade de assessorar, estudar e propor ao Conselho de Governo, diretrizes de pol??ticas governamentais para o meio ambiente e os recursos naturais",
                "Os Estados, na esfera de suas compet??ncias e nas ??reas de sua jurisdi????o, elaborar??o normas supletivas e complementares e padr??es relacionados com o meio ambiente, observados os que forem estabelecidos pelo CONAMA.",
                "",
                "C"
        );
         Question3 q38 = new Question3(
                 null,
                 "Qual a import??ncia do SISNAMA no controle dos problemas ambientais?",
                 null,null,null,null,
                 "o SISNAMA cuida da gest??o ambiental do pa??s, auxiliando no cumprimento dos principios legais de prote????o, melhoria e recupera????o da qualidade ambiental"
         );

        Question3 q39 = new Question3(
                null,
                "Qual a compet??ncia do SISNAMA?",
                null,null,null,null,
                "Planejar, coordenar, controlar e supervisionar as a????es relativas ?? Pol??tica Nacional do Meio Ambiente e as diretrizes estabelecidas para o meio ambiente"
        );

        question1Repository.saveAll(Arrays.asList(q11,q12,q13, q14, q15,q16,q17,q18,q19));
        question3Repository.saveAll(Arrays.asList(q31,q32,q33, q34, q35,q36,q37,q38,q39));
        question2Repository.saveAll(Arrays.asList(q21,q22,q23, q24, q25,q26,q27,q28,q29));
    }
}
