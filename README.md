# ExercicioChainOfResposibility_EGIII

Implementar em Java, com camada model completa e camada de persistência para a solução do seguinte problema:

Um sistema de pagamento de funcionários que precisa cadastrar os funcionários por um ID único (INT), nome (VARCHAR(60)), salário (FLOAT). O sistema deve permitir o CRUD Completo dessa entidade e um Select ALL.
 Além disso, o sistema deve ter, na camada de controle, uma forma* de calcular, para posterior exibição, do desconto INSS do funcionário, que segue o seguinte padrão:
Até R$ 1.212,00 (salário-mínimo) – 7,5% do salário
Entre R$ 1. 212,00 e R$ 2.427,35 – 9% da diferença
Entre R$ 2.427,36 e R$ 3.641,03 – 12% da diferença
Entre R$ 3.641,03 e R$ 7.087,22– 14% da diferença
Exemplo 1:
Se um trabalhador ganha R$ 1.500,00, o desconto do INSS será de 7,5% sobre R$ 1.212,00 (R$ 90,90) + a alíquota de 9% sobre a quantia que está na faixa seguinte (1.500,00 – 1.212,00 = R$ 288). O valor será de R$ 25,92.

Cálculo final: R$ 90,90+ R$ 25,92 = R$ 116,82

Para calcular a alíquota efetiva, divida o valor efetivo pelo salário do trabalhador (116,82÷ 1.500,00), o que resultará em 7,88% do seu salário.

Exemplo 2:

Se um trabalhador ganha R$ 3.000,00, ele se encontra na terceira faixa (R$ 2.427,36 e R$ 3.641,03). Será necessário calcular o valor da alíquota para cada faixa:

1ª faixa salarial: 1.212,00 x 7,5% = 90,90

2ª faixa salarial: [2.427,35 – 1.212,00] x 9% = 1.215,35 x 9% = 109,38

Faixa que atinge o salário: [3.000,00 – 2.427,35] x 12% = 572,65 x 12% = 68,71

Total a recolher: 90,90 + 109,38 + 68,71 = 268,99

O desconto do INSS tem um teto de contribuição, que é de R$ 7.087,22. Além disso, é importante destacar que os ajustes também valem para empregados domésticos e trabalhadores avulsos.

*Usar Chain of Responsability