/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cadastrobd;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridicaDAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author regin
 */
public class Cadastrobd {

    public static void main(String[] args) {
        // Instanciar os DAOs
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        try {
            // Adicionar Pessoa Física
            PessoaFisica pessoaFisica = new PessoaFisica(0, "João da Silva", "Rua A", "Cidade X", "Estado Y", "123456789", "joao@example.com", "12345678900");
            pessoaFisicaDAO.incluir(pessoaFisica);
            System.out.println("Pessoa Física adicionada com sucesso!");

            // Adicionar Pessoa Jurídica
            PessoaJuridica pessoaJuridica = new PessoaJuridica(0, "Empresa XYZ Ltda", "Av. B", "Cidade Z", "Estado W", "987654321", "contato@empresa.com", "12345678000199");
            pessoaJuridicaDAO.incluir(pessoaJuridica);
            System.out.println("Pessoa Jurídica adicionada com sucesso!");

            // Listar todas as Pessoas Físicas
            System.out.println("Pessoas Físicas:");
            List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
            for (PessoaFisica pf : pessoasFisicas) {
                System.out.println(pf);
            }

            // Listar todas as Pessoas Jurídicas
            System.out.println("Pessoas Jurídicas:");
            List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
            for (PessoaJuridica pj : pessoasJuridicas) {
                System.out.println(pj);
            }

            // Alterar Pessoa Física
            if (!pessoasFisicas.isEmpty()) {
                PessoaFisica pfParaAlterar = pessoasFisicas.get(0);
                pfParaAlterar.setNome("João da Silva Alterado");
                pessoaFisicaDAO.alterar(pfParaAlterar);
                System.out.println("Pessoa Física alterada com sucesso!");
            }

            // Alterar Pessoa Jurídica
            if (!pessoasJuridicas.isEmpty()) {
                PessoaJuridica pjParaAlterar = pessoasJuridicas.get(0);
                pjParaAlterar.setNome("Empresa XYZ Alterada");
                pessoaJuridicaDAO.alterar(pjParaAlterar);
                System.out.println("Pessoa Jurídica alterada com sucesso!");
            }

            // Excluir Pessoa Física
            if (!pessoasFisicas.isEmpty()) {
                PessoaFisica pfParaExcluir = pessoasFisicas.get(0);
                pessoaFisicaDAO.excluir(pfParaExcluir.getId());
                System.out.println("Pessoa Física excluída com sucesso!");
            }

            // Excluir Pessoa Jurídica
            if (!pessoasJuridicas.isEmpty()) {
                PessoaJuridica pjParaExcluir = pessoasJuridicas.get(0);
                pessoaJuridicaDAO.excluir(pjParaExcluir.getId());
                System.out.println("Pessoa Jurídica excluída com sucesso!");
            }
        } catch (SQLException e) {
        }
    }
}
