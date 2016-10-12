package operacoes;
import java.util.*;
/**
 * @author Monique e Letícia
 */

public class Operacoes {
    
    public int executaOperacao(List<String> memory, int N){
        String copiaPalavra = memory.get(N);
        copiaPalavra = copiaPalavra.substring(0, 4);
        int tipoEnd = this.identificaEnd(memory, N);
        
        switch(copiaPalavra){
            case "0000":
                N = this.br(memory, N+1, tipoEnd);
            break;
            
            case "0001":
                N = this.brPos(memory, N+1, tipoEnd);
            break;
            
            case "0010":
                N = this.add(memory, N+1, tipoEnd);
            break;
            
            case "0011":
                N = this.load(memory, N+1, tipoEnd);
            break;
            
            case "0100":
                N = this.brZero(memory, N+1, tipoEnd);
            break;
            
            case "0101":
                N = this.brNeg(memory, N+1, tipoEnd);
            break;
            
            case "0110":
                N = this.sub(memory, N+1, tipoEnd);
            break;
                
            case "0111":
                N = this.store(memory, N+1, tipoEnd);
            break;    
                
            case "1000":
                N = this.write(memory, N+1, tipoEnd);
            break;
                
            case "1001":
                N = this.ret(memory);
            break;
                
            case "1010":
                N = this.divide(memory, N+1, tipoEnd);
            break;
                
            case "1011":
                N = this.stop(N);
            break;
                
            case "1100":
                N = this.read(memory, N);
            break;
                
            case "1101":
                N = this.copy(memory, N);
            break;
            
            case "1110":
                N = this.mult(memory, N+1, tipoEnd);
            break;
            
            case "1111":
                N = this.call(memory, N, tipoEnd);
            break;    
        }
        return N;
    } 
  
    private int add(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
             
        setACC(acumulador + operando);
        setPC(getPC() + 1);
        
        return N+1;
    }
    
    private int br(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
                
        setPC(getPC() - N - 1 + operando);
        
        return operando;
    }
    
    private int brNeg(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
        
        if(acumulador < 0){
            setPC(getPC() - N - 1 + operando);
            return operando;
        }else{
            setPC(getPC() + 1);
            return N+1;
        }
    }
    
    private int brPos(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
        
        if(acumulador > 0){
            setPC(getPC() - N - 1 + operando);
            return operando;
        }else{
            setPC(getPC() + 1);
            return N+1;
        }
    }
    
    private int brZero(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
        
        if(acumulador == 0){
            setPC(getPC() - N - 1 + operando);
            return operando;
        }else{
            setPC(getPC() + 1);
            return N+1;
        }
    }
    
    private int call(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        setSP(getPC());
        setPC(getPC() - N - 1 + operando);
        return operando;
    }
    
    private int copy(List<String> memory, int N){
        String copiaPalavra = memory.get(N);
        N = N+1;
        if(copiaPalavra.charAt(5) == '1' && copiaPalavra.charAt(6) == '1' ){
            //ERRO
        }else if(copiaPalavra.charAt(4) == '1'){
            //OP1 = indireto
            if(copiaPalavra.charAt(5) == '1'){
                int operando2 = this.recebeOperando(memory, N+1, 4);//OP2 = indireto  
                setDadoInd(memory.get(N), operando2);
            }else if(copiaPalavra.charAt(6) == '1'){
                int operando2 = this.recebeOperando(memory, N+1, 6);//OP2 = imediato
                setDadoInd(memory.get(N), operando2);
            }else{
                int operando2 = this.recebeOperando(memory, N+1, 0);//OP2 = direto
                setDadoInd(memory.get(N), operando2);
            }
        }else if(copiaPalavra.charAt(4) == '0'){
            //OP1 = direto
            if(copiaPalavra.charAt(5) == '1'){
                int operando2 = this.recebeOperando(memory, N+1, 4);//OP2 = indireto
                setDado(memory.get(N), operando2);
            }else if(copiaPalavra.charAt(6) == '1'){
                int operando2 = this.recebeOperando(memory, N+1, 6);//OP2 = imediato
                setDado(memory.get(N), operando2);
            }else{
                int operando2 = this.recebeOperando(memory, N+1, 0);//OP2 = direto
                setDado(memory.get(N), operando2);
            }
        }     
        setPC(getPC() + 2);
        return N+2;
    }
        
    private int divide(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
        
        if (operando != 0){
            setACC(acumulador / operando);
        }else{
            //freitag printa o erro
        }
        setPC(getPC() + 1);
        
        return N+1;
    }
    
    private int mult(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
        
        setACC(acumulador * operando);
        setPC(getPC() + 1); 
        
        return N+1;
    }
    
    private int load(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        
        setACC(operando);
        setPC(getPC() + 1);
        
        return N+1;
    }
    
    private int read(List<String> memory, int N){//ver se tem que converter o input pra mandar em int e não string
        String copiaPalavra = memory.get(N);
        N = N + 1;
        if(copiaPalavra.charAt(6) == '1'){
            //ERRO
        }else if(copiaPalavra.charAt(4) == '1' || copiaPalavra.charAt(5) == '1'){
            setDadoInd(memory.get(N), getInput());//Indireto
        }else{
            setDado(memory.get(N), getInput());//Direto
        }
        
        setPC(getPC() + 2);
        return N + 1;
    }
    
    private int ret(List<String> memory){
        setPC(getSP());
        return (getPC() - inicioPC);
    }
    
    private int stop(int N){
        setPC(getPC() + 1);
        return -1;
    }
     
    private int store(List<String> memory, int N, int tipoEnd){
        
        if (tipoEnd == 0){
            setDado(memory.get(N), getACC());
        }else if (tipoEnd == 4){
            setDadoInd(memory.get(N), getACC());
        }else {
            //ERRO
        }
        
        setPC(getPC() + 1);
        return N+1;
    }
       
    private int sub(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        int acumulador = getACC();
                
        setACC(acumulador - operando);
        setPC(getPC() + 1); 
        
        return N+1;
    }
    
    private int write(List<String> memory, int N, int tipoEnd){
        int operando = this.recebeOperando(memory, N, tipoEnd);
        setOutput(operando);
        
        setPC(getPC() + 2);
        
        return N+1;
    }
    
    private int identificaEnd(List<String> memory, int N){
        //4 indicam INDIRETO 
        //6 indica IMEDIATO
        //0 indica DIRETO
        String copiaPalavra = memory.get(N);
        
            if (copiaPalavra.charAt(4) == '1' || copiaPalavra.charAt(5) == '1' && copiaPalavra.charAt(6) == '1'){
                return -1; //-1 corresponde a erro, método de endereçamento inválido
            } else if (copiaPalavra.charAt(4) == '1' || copiaPalavra.charAt(5) == '1' && copiaPalavra.charAt(6) == '0'){
                return 4;
            } else if (copiaPalavra.charAt(6) == '1'){
                return 6;
            } else
                return 0;
            
    }
    
    private int recebeOperando(List<String> memory, int N, int tipoEnd){
        int operando = 0;
        if (tipoEnd == 6){ 
            operando = Integer.parseInt(memory.get(N)); // IMEDIATO
        } else if (tipoEnd == 0){
            operando = Integer.parseInt(getDado(memory.get(N))); //DIRETO
        } else if (tipoEnd == 4){
            operando = Integer.parseInt(getDadoInd(memory.get(N))); //INDIRETO
        }
        return operando;
    }
}
