#API Utilizada:
"https://opentdb.com/api.php?amount=1&category=27&difficulty=easy&type=multiple";

#Executar o projeto:

Abra o IntelliJ IDEA e selecione "Open" no menu principal.
Navegue até o diretório onde exportou o projeto e selecione a pasta do projeto.
Clique em "OK" para abrir o projeto no IntelliJ.
Executar a Aplicação:
No IntelliJ, localize a classe quizController.
Clique com o botão direito do mouse na classe e selecione "Run 'quizController'".
Isso iniciará o servidor Spring Boot e tornará a aplicação disponível para acesso.
Testar a Aplicação:
Abra um navegador da web e acesse http://localhost:8080/quiz para receber uma pergunta.
Para enviar uma resposta, você pode usar ferramentas como Postman ou cURL para enviar uma requisição POST para http://localhost:8080/answer, fornecendo a resposta correta e a resposta do usuário no corpo da requisição.


#Obtenção de Pergunta e Respostas (GET):
O endpoint GET "/quiz" faz uma requisição para uma API externa que fornece perguntas de quiz.
A pergunta e as respostas são extraídas da resposta da API.
A pergunta e a resposta correta são enviadas como JSON de resposta para o usuário.
Verificação de Resposta do Usuário (POST):
O usuário envia sua resposta para o endpoint POST "/answer" junto com a resposta correta.
O servidor compara a resposta do usuário com a resposta correta.
Um JSON de resposta é enviado de volta para o usuário, indicando se a resposta do usuário está correta ou não.

Funcionamento sem Banco de Dados:
Atualmente, a aplicação não utiliza um banco de dados para armazenar perguntas e respostas. Em vez disso, as perguntas são obtidas de uma API externa em tempo real.
Isso significa que, a cada vez que um usuário acessa o endpoint /quiz, uma nova pergunta é solicitada à API externa, e a resposta correta é enviada de volta para o usuário.
Da mesma forma, ao enviar uma resposta para o endpoint /quiz/answer, não há armazenamento das respostas ou resultados no servidor, pois não há banco de dados para armazená-los.
Limitações e Considerações:
Como o servidor não mantém o estado das perguntas ou respostas, os usuários podem receber a resposta correta quando solicitam uma pergunta. Isso não reflete a experiência de uma aplicação real de quiz, onde as perguntas geralmente são pré-definidas e não mudam a cada solicitação.
Em uma aplicação real, as perguntas e respostas seriam armazenadas em um banco de dados, e o servidor buscaria e gerenciaria esses dados a partir do banco de dados, em vez de fazer uma requisição a uma API externa toda vez que um usuário solicita uma pergunta.
Além disso, em uma aplicação real, o front-end seria responsável por lidar com a apresentação da pergunta e das opções de resposta ao usuário, sem expor explicitamente a resposta correta. A validação da resposta seria enviada ao servidor para verificação, mas a resposta correta não seria enviada de volta ao cliente.

