package com.ojcarlos.simplecrud.config;

import com.ojcarlos.simplecrud.entities.*;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        Question1 q11 = new Question1(null,
                "Qual risco está relacionado à possibilidade de ocorrência de danos, seja dentro de um\n" +
                        "período pequeno ou grande de tempo com os prejuízos sendo causados por fatores de\n" +
                        "ordem natural, social ou tecnológica?",
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
                "O risco natural é a denominação que faz referência àqueles riscos que\n" +
                        "não podem ser facilmente atribuídos ou relacionáveis à ação humana, tais quais:\n" +
                        "riscos tectônicos e magmáticos; riscos e os riscos hidrológicos."
        );
        Question1 q13 = new Question1(
                null,
                "Quais dos seguintes elementos não está relacionado ao risco tecnológico",
                "A) Processo de trabalho (relações entre direções empresariais e estatais e assalariados)",
                "B) Período de tempo, pequeno ou grande, no qual pode ocorrer a possibilidade de danos",
                "C) Processo de produção (recursos, técnicas, equipamentos, maquinário)",
                null,
                "Letra B"
        );

        Question2 q21 = new Question2 (
                null,
                "Dentre os riscos sociais, existem aqueles classificados como riscos endógenos. O que vem a ser risco endógeno?",
                "Riscos relacionados à administração adotada, como crescimento urbano e industrialização;",
                "Riscos relacionados à administração adotada, como crescimento urbano e industrialização",
                "Risco relacionado ao processo de produção (recursos, técnicas, equipamentos, maquinário)",
                null,
                "A"
        );

        Question2 q22 = new Question2(
                null,
                "5. Dentre os riscos sociais, existem aqueles classificados como riscos exógenos. O que vem a ser um risco exógeno?",
                "A) Risco que está relacionado a um período, seja um período pequeno ou grande",
                "B) Riscos relacionados à administração adotada, como crescimento urbano e industrialização;",
                "C) Riscos relacionados a ameaças externas como: terremotos, epidemias, secas e inundações;",
                null,
                "B"

        );
        Question2 q23 = new Question2(
                null,
                "Qual a diferença entre riscos e impactos ambientais?",
                null,null,null,null,
                "Risco ambiental remete à possibilidade de ocorrência de eventos danosos ao ambiente, enquanto que, a noção de impacto ambiental está ligada à repetição de algo que já aconteceu e que poderá significar um evento positivo ou negativo, podendo comprometer a licença para instalar um empreendimento em determinado local."
        );

        Question3 q31 = new Question3(
                null,
                "Os métodos de Avaliação de Impacto Ambiental servem de referência nos estudos ambientais para determinar de forma mais precisa e significativa um impacto ambiental. Modelos matemáticos destinados a representar o comportamento dos parâmetros ambientais ou das relações de causa e efeito de determinadas ações, refere-se ao conceito do método:",
                "A) Métodos de Simulação.",
                "B) Redes de Interação.",
                "C) Metodologias Quantitativas.",
                null,
                "A"
        );

        Question3 q32 = new Question3(
          null,
          "Os métodos de Avaliação de Impacto Ambiental servem de referência nos estudos ambientais para determinar de forma mais precisa e significativa um impacto ambiental. Dentre os métodos, o que vem a ser as redes de interação?",
           null,null,null,null,
           "As redes têm por objetivo as relações precedência entre ações praticadas pelo empreendimento e os consequentes impactos de primeira e demais ordens. Apresentam como vantagens o fato de permitirem uma boa visualização de impactos secundários e demais ordens."
        );

        Question3 q33 = new Question3(
                null,
                "Em relação ao Estudo de Impacto Ambiental (EIA), diga qual é a alternativa incorreta:",
                "O EIA é o estudo das prováveis modificações nas diversas características socioeconômicas e biofísicas do meio ambiente que podem resultar de um projeto proposto, estabelecendo medidas de prevenção, mitigação e monitoramento dos danos ambientais.",
                "Para que o EIA seja juridicamente válido, a Resolução do CONAMA nº 01/86 exige que sejam observados alguns requisitos, como a identificação de impactos ambientais gerados nas fases de implantação.",
                "O EIA é um resumo do Relatório de Impacto Ambiental (RIMA) e deve conter todas as informações incluídas naquele, de forma resumida, simplificada e acessível.",
                null,
                "C"
        );

        Question1 q14 = new Question1(
                null,
                "Em setembro de 2015, a ONU (Organização das Nações Unidas) definiu objetivos de desenvolvimento sustentável (ODS), que devem ser implantados por todos os países do mundo até 2030. Quantos objetivos são?",
                null, null,null,null,
                "17"
        );

        Question1 q15 = new Question1(
                null,
                "Segundo os ODS (objetivos de desenvolvimento sustentável), que todos os países devem implantar até 2030, qual das alternativas abaixo não apresenta objetivos de desenvolvimento sustentável?",
                "Erradicação da pobreza; Fome zero e agricultura sustentável; Saúde e bem-estar; Energia Limpa e Acessível",
                "Educação de qualidade; Igualdade de gênero; Água Potável e Saneamento; Consumo e produção responsáveis;",
                "Salários Justos; Liberdade de escolha; Acesso a informação; Direitos sociais e políticos;",
                null,
                "C"
        );

        Question1 q16 = new Question1(
                null,
                "Salários Justos; Liberdade de escolha; Acesso a informação; Direitos sociais e políticos;",
                null, null,null,null,
                "São ações para acabar com a pobreza, proteger o meio ambiente e o clima e garantir que as pessoas, em todos os lugares, possam desfrutar de paz e de prosperidade, definidos pelo ONU, devem ser implementados até 2030."
                );
        Question2 q24 = new Question2(
                null,
                "Sobre os objetivos de desenvolvimento sustentável, qual alternativa não descreve um dos objetivos da Erradicação da Pobreza?",
                "Até 2030, acabar com a fome e garantir o acesso de todas as pessoas, em particular os pobres e pessoas em situações vulneráveis, incluindo crianças, a alimentos seguros, nutritivos e suficientes durante todo o ano.",
                "Até 2030, erradicar a pobreza extrema para todas as pessoas em todos os lugares, atualmente medida como pessoas vivendo com menos de US$ 1,90 por dia.",
                "",
                "",
                "A"
        );

        Question2 q25 = new Question2(
                null,
                "Sobre os objetivos de desenvolvimento sustentável, qual alternativa não descreve um dos objetivos da Água Potável e Saneamento?",
                "Até 2030, alcançar o acesso universal e equitativo a água potável e segura para todos.",
                "Até 2030, implementar a gestão integrada dos recursos hídricos em todos os níveis, inclusive via cooperação transfronteiriça, conforme apropriado.",
                "Minimizar e enfrentar os impactos da acidificação dos oceanos, inclusive por meio do reforço da cooperação científica em todos os níveis.",
                null,
                "C"
                );

        Question2 q26 = new Question2(
                null,
                "Aumentar a urbanização inclusiva e sustentável, e as capacidades para o planejamento e gestão de assentamentos humanos participativos, integrados e sustentáveis, em todos os países, é um objetivo específico de:",
                "Consumo e produção responsáveis;",
                "Cidades e comunidades sustentáveis;",
                "Indústria, inovação e infraestrutura;",
                null,
                "B"

        );

        Question3 q34 = new Question3(
                null,
                "cabar com as epidemias de AIDS, tuberculose, malária e doenças tropicais negligenciadas, e combater a hepatite, doenças transmitidas pela água, e outras doenças transmissíveis, é um objetivo específico de:",
                "Água potável e saneamento;",
                "Indústria, inovação e infraestrutura;",
                "Saúde e Bem-Estar;",
                null,
                "C"
        );
        Question3 q35 = new Question3(
               null,
               "Qual das alternativas abaixo é um objetivo específico da Igualdade de gênero?\n",
               "Até 2030, alcançar o emprego pleno e produtivo e trabalho decente para todas as mulheres e homens, inclusive para os jovens e as pessoas com deficiência, e remuneração igual para trabalho de igual valor.",
               "Garantir a participação plena e efetiva das mulheres e a igualdade de oportunidades para a liderança em todos os níveis de tomada de decisão na vida política, econômica e pública.",
               "Até 2020, reduzir substancialmente a proporção de jovens sem emprego, educação ou formação.",
               null,
               "B"
        );

        Question3 q36 = new Question3(
                null,
                "Cite três ODS (objetivos de desenvolvimento sustentável) definidos pela ONU, em 2015.",
                null, null,null,null,
                "Erradicação da pobreza, fome zero e agricultura sustentável, saúde e bem-estar, educação de qualidade, igualdade de gênero, água potável e saneamento, energia limpa e acessível, trabalho decente e crescimento econômico, indústria inovação e infraestrutura, redução das desigualdades, cidades e comunidades sustentáveis, consumo e produção responsáveis, ação contra a mudança global do clima, vida na água, vida terrestre, paz justiça e instituições eficazes, parcerias e meios de implementação."

                );

        Question1 q17 = new Question1(
                null,
                "O que é o SISNAMA?",
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
                "3. Qual a função do CONAMA?\n",
                null, null,null,null,
                "assessorar, estudar e propor ao Conselho de Governo e demais órgãos ambientais diretrizes e políticas governamentais para o meio ambiente e deliberar, no âmbito de suas competências, sobre normas e padrões para o meio ambiente."

        );

        Question2 q27 = new Question2(
                null,
                "O que significa a sigla CONAMA?",
                null,null,null,null,
                "R: Conselho Nacional do Meio Ambiente"
        );

        Question2 q28 = new Question2(
                null,
                "Assinale a alternativa que indica corretamente a sigla da estrutura adotada para a gestão ambiental no Brasil, formada pelos órgãos e entidades da União, dos Estados, do Distrito Federal e dos Municípios responsáveis pela proteção, melhoria e recuperação da qualidade ambiental no Brasil, criada pela Lei 6.938/1981 e regulamentada pelo Decreto 99274/1990.",
                "FATMA",
                "FEPAM",
                "CONAMA",
                "SISNAMA",
                "D"
        );
        Question2 q29 = new Question2(
                null,
                "De acordo com a Lei Nacional que institui o Sistema Nacional do Meio Ambiente (SISNAMA), que previu as competências do Conselho Nacional do Meio Ambiente (CONAMA), é correto inferir que se inseri dentro do conceito de preservação, melhoria e recuperação da qualidade ambiental, previstos na Lei de Política Nacional do Meio Ambiente (Lei n°  6.938/1981)",
                "Ação governamental na manutenção do equilíbrio ecológico, considerando o meio ambiente como um patrimônio público a ser necessariamente assegurado e protegido, tendo em vista o uso coletivo.",
                "Controle irrestrito do uso do solo, do subsolo, da água e do ar, com limitação para seu uso.",
                "",
                "",
                "A"
        );

        Question3 q37 = new Question3(
                null,
                "Sobre a Lei nº 6.938, de 1981 e suas alterações, que dispõe sobre a Política Nacional do Meio Ambiente, seus fins e mecanismos de formulação e aplicação, e dá outras providências, é CORRETO afirmar que:\n",
                "Os órgãos e entidades da União, dos Estados, do Distrito Federal, dos Territórios e dos Municípios, bem como as fundações instituídas pelo Poder Público, responsáveis pela proteção e melhoria da qualidade ambiental, constituirão o Conselho Nacional do Meio Ambiente (CONAMA)",
                "O Sistema Nacional do Meio Ambiente – SISNAMA é órgão consultivo e deliberativo com a finalidade de assessorar, estudar e propor ao Conselho de Governo, diretrizes de políticas governamentais para o meio ambiente e os recursos naturais",
                "Os Estados, na esfera de suas competências e nas áreas de sua jurisdição, elaborarão normas supletivas e complementares e padrões relacionados com o meio ambiente, observados os que forem estabelecidos pelo CONAMA.",
                "",
                "C"
        );
         Question3 q38 = new Question3(
                 null,
                 "Qual a importância do SISNAMA no controle dos problemas ambientais?",
                 null,null,null,null,
                 "o SISNAMA cuida da gestão ambiental do país, auxiliando no cumprimento dos principios legais de proteção, melhoria e recuperação da qualidade ambiental"
         );

        Question3 q39 = new Question3(
                null,
                "Qual a competência do SISNAMA?",
                null,null,null,null,
                "Planejar, coordenar, controlar e supervisionar as ações relativas à Política Nacional do Meio Ambiente e as diretrizes estabelecidas para o meio ambiente"
        );

        question1Repository.saveAll(Arrays.asList(q11,q12,q13, q14, q15,q16,q17,q18,q19));
        question3Repository.saveAll(Arrays.asList(q31,q32,q33, q34, q35,q36,q37,q38,q39));
        question2Repository.saveAll(Arrays.asList(q21,q22,q23, q24, q25,q26,q27,q28,q29));
    }
}
