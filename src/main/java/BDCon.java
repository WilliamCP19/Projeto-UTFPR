//NOME WILLIAM DA CRUZ PIRES    RA:2313707
//ENGENHARIA DE SOFTWARE    2021/2

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class BDCon {
    private List <Mesa> xbos = new ArrayList <Mesa>();
    private List <Portatil> nin = new ArrayList <Portatil>();
    
    private static BDCon tab;

    private BDCon() {
        nin.add(new Portatil ("NINTENDO SWITCH"));
        xbos.add(new Mesa ("PLAYSTATION 5"));
        xbos.add(new Mesa ("XBOX SERIES", 12));
    }

    public List<Mesa> getXbos() {
        return xbos;
    }

    public List<Portatil> getNin() {
        return nin;
    }

    public static BDCon getGerCon() {
        if (tab == null)
            tab = new BDCon ();
        return tab;
    }
    
    public void numeraMesa (int esc) {
        if (esc == 0) {
            for (Mesa ms : xbos) {
                ms.getDev().setCnpj(ms.getDev().getCnpj() + 1);
            }
        } else if (esc == 1) {
            for (Mesa ms : xbos) {
                ms.getDev().setCnpj(ms.getDev().getCnpj() - 1);
            }
        }
    }
    
    public void numeraPortatil (int esc) {
        
        if (esc == 0) {
            for (Portatil n : nin) {
                n.getDev().setCnpj(n.getDev().getCnpj() + 1);
            }    
        } else if (esc == 1) {
            for (Portatil n : nin) {
                n.getDev().setCnpj(n.getDev().getCnpj() - 1);
            }
        }
    }
    
    public Portatil buscaPortatil (int portable) {
        for (int i = 0;i < nin.size();i++) {
            if (portable == nin.get(i).getDev().getCnpj()) {
                return nin.get(i);
            }
        }
        return null;
    }
    
    
    public void adicionaPortatil (Portatil portabel) {
        portabel = leitorDadosPortatil (new Portatil(), tab.nin.get(0).getDev().getCnpj() + 1);
        tab.nin.add(portabel);
    }
  
    public Mesa buscaMesa (int psx) {
        for (int i = 0;i < xbos.size();i++) {
            if (psx == xbos.get(i).getDev().getCnpj()){
                return xbos.get(i);
            }
        }
        return null;
    }
    
    
    
    public void adicionaMesa (Mesa psx) {
        psx = leitorDadosMesa (new Mesa(), tab.nin.get(0).getDev().getCnpj());
        numeraPortatil(0);
        tab.xbos.add(psx); 
    }
    
    public Mesa leitorDadosMesa (Mesa psx, int novoCnpj) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome da Fabricante:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
        String sede = JOptionPane.showInputDialog(null, "Onde se encontra a sede desta empresa:", "atualiza????o", JOptionPane.QUESTION_MESSAGE);
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ANO DE FUNDA????O desta empresa [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
        String atuacao = JOptionPane.showInputDialog(null, "Digite a AREA DE ATUA????O desta empresa:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
        String situacao = JOptionPane.showInputDialog(null, "Digite o sita????o da empresa\nEst?? 'ATIVA' ou 'DESATIVADA:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
        
        psx.getDev().setFantasia(nome.toUpperCase().toUpperCase());
        psx.getDev().setSede(sede.toUpperCase());
        psx.getDev().setAno(ano);
        psx.getDev().setArea(atuacao.toUpperCase());
        psx.getDev().setSituacao(situacao.toUpperCase());
        
        psx.getDev().setCnpj(novoCnpj);
    
        try {
            nome = JOptionPane.showInputDialog(null, "Digite o NOME COMERCIAL DO PRODUTO:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String cpu = JOptionPane.showInputDialog(null, "Digite as especifica????es da CPU:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String gpu = JOptionPane.showInputDialog(null, "Digite as especifica????es da GPU:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            int ram = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantos GB tem a Mem??ria RAM [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
            String arm = JOptionPane.showInputDialog(null, "Digite a capacidade de armazenamento do armazenamemnto interno:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String formato  = JOptionPane.showInputDialog(null, "O armazenamento ?? um SSD ou HDD:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            int tera = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a pot??ncia do console em TERAFLOPS [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
            String audio = JOptionPane.showInputDialog(null, "Digite a tecnologia de ??udio:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String ray = JOptionPane.showInputDialog(null, "Digite a capacidade do Blu-Ray:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            
            psx.setMarca(nome.toUpperCase());
            psx.setCpu(cpu.toUpperCase());
            psx.setGpu(gpu.toUpperCase());
            psx.setRam(ram);
            psx.setArmazena(arm.toUpperCase());
            psx.setFormato_SSD(formato.toUpperCase());
            psx.setTeraflops(tera);
            psx.setAudio(audio.toUpperCase());
            psx.setBlu(ray.toUpperCase());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "A ENTRADA DEVE SER UM N??MERO INTEIRO:", "Erro Formato de N??mero", JOptionPane.ERROR_MESSAGE);
            atualizarMesa (psx);
        }
        return psx;
    }
    
    public void atualizarMesa (Mesa psx) {
        int i;
        for (i = 0;i < xbos.size();i++) {
            if (psx.getDev().getCnpj() == xbos.get(i).getDev().getCnpj()) {
                break;
            }
        }
        psx = leitorDadosMesa (psx, psx.getDev().getCnpj());
        tab.xbos.set(i, psx);
    }
    
    public Portatil leitorDadosPortatil (Portatil portable, int novoCnpj) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome da Fabricante:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
        String sede = JOptionPane.showInputDialog(null, "Onde se encontra a sede desta empresa:", "atualiza????o", JOptionPane.QUESTION_MESSAGE);
        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ANO DE FUNDA????O desta empresa [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
        String atuacao = JOptionPane.showInputDialog(null, "Digite a AREA DE ATUA????O desta empresa:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
        String situacao = JOptionPane.showInputDialog(null, "Digite o sita????o da empresa\nEst?? 'ATIVA' ou 'DESATIVADA:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
        
        portable.getDev().setFantasia(nome.toUpperCase());
        portable.getDev().setSede(sede.toUpperCase());
        portable.getDev().setAno(ano);
        portable.getDev().setArea(atuacao.toUpperCase());
        portable.getDev().setSituacao(situacao.toUpperCase());
    
        portable.getDev().setCnpj(novoCnpj);
        
        try {
            nome = JOptionPane.showInputDialog(null, "Digite o NOME COMERCIAL DO PRODUTO:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String cpu = JOptionPane.showInputDialog(null, "Digite as especifica????es da CPU:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String gpu = JOptionPane.showInputDialog(null, "Digite as especifica????es da GPU:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            int ram = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantos GB tem a Mem??ria RAM [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
            String arm = JOptionPane.showInputDialog(null, "Digite a capacidade de armazenamento do armazenamemnto interno:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            int tera = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a pot??ncia do console em TERAFLOPS [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
            int tela = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a polega da Tela [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
            int bateria = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a miliamp??re-hora da bateria [Em n??mero inteiro]:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE));
            String falante = JOptionPane.showInputDialog(null, "Digite o formato de auto falante presente no console", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            String cam = JOptionPane.showInputDialog(null, "Digite o tipo de c??mera do console:", "Atualiza????o", JOptionPane.QUESTION_MESSAGE);
            
            portable.setMarca(nome.toUpperCase());
            portable.setCpu(cpu.toUpperCase());
            portable.setGpu(gpu.toUpperCase());
            portable.setRam(ram);
            portable.setArmazena(arm.toUpperCase());
            portable.setTeraflops(tera);
            portable.setTela(tela);
            portable.setBateria(bateria);
            portable.setFalante(falante.toUpperCase());
            portable.setCamera(cam.toUpperCase());
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "A ENTRADA DEVE SER UM N??MERO INTEIRO:", "Erro Formato de N??mero", JOptionPane.ERROR_MESSAGE);
        }
        return portable;
    }
    
    public void atualizarPortatil (Portatil portable) {
        int i;
        for (i = 0;i < nin.size();i++) {
            if (portable.getDev().getCnpj() == nin.get(i).getDev().getCnpj()) {
                break;
            }
        }
        portable = leitorDadosPortatil(portable, portable.getDev().getCnpj());
        tab.nin.set(i, portable);
    }
}