package domain

import domain.criterios.Basico
import domain.criterios.CriterioDeAprovacao
import domain.criterios.Intermediario
import domain.criterios.Rigoroso

class AnalisadorDeAprovacao {

  private lateinit var cda: CriterioDeAprovacao

  fun defineCriterio(criterio: CriterioDeAprovacao) {
    cda = criterio
  }

  fun fechaBoletim(boletim: Boletim): BoletimFechado {
    var bf: BoletimFechado = BoletimFechado(
      boletim.mediaEPs,
      boletim.mediaMiniEPs,
      cda.mediaFinal(boletim),
      cda.estaAprovado(boletim)
    )

    return bf
  }
}
