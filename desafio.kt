// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {
    BASICO, INTERMEDIARIO, AVANCADO
}

class ConteudoEducacional(
    val titulo: String,
    val descricao: String,
    val autor: String,
    val duracao: Int
)

class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {
    val alunosMatriculados = mutableListOf<Aluno>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricularAluno(vararg alunos: Aluno) {
        alunosMatriculados.addAll(alunos)
    }
}

class Aluno(val nome: String)

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", "Aprenda os conceitos básicos do Kotlin.", "Instrutor João", 45)
    val conteudo2 = ConteudoEducacional("Java Completo 2023", "Programação Java do Básico ao Avançado.", "Instrutor Railson", 120)

    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO)
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    val aluno1 = Aluno("José")
    val aluno2 = Aluno("Maria")

    formacaoKotlin.matricularAluno(aluno1, aluno2)

    println("FORMAÇÃO: ${formacaoKotlin.nome}")
    println("NÍVEL: ${formacaoKotlin.nivel}")
    println("DURAÇÃO DO CURSO: ${formacaoKotlin.conteudos.sumBy { it.duracao }} minutos") // Calcula a duração total dos conteúdos
    println("CONTEÚDOS EDUCACIONAIS:")
    for (conteudo in formacaoKotlin.conteudos) {
        println("- ${conteudo.titulo} (Autor: ${conteudo.autor}, Duração: ${conteudo.duracao} minutos)")
    }

    println("Alunos matriculados:")
    for (aluno in formacaoKotlin.alunosMatriculados) {
        println("- ${aluno.nome}")
    }
}
