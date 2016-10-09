import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class OperacoesTest {
  
  @Test
  public void testAdd() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0010000000000000");
    memory.add("0010000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testBr() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0000000000000000");
    memory.add("0000000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testBrNeg() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0101000000000000");
    memory.add("0101000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testBrPos() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0001000000000000");
    memory.add("0001000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testBrZero() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0100000000000000");
    memory.add("01000000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testCall() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1111000000000000");
    memory.add("1111000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testCopy() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1101000000000000");
    memory.add("1101000000000000");
    memory.add("1101000000000000");
    assertEquals(3, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testDivide() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1010000000000000");
    memory.add("1010000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testMult() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1110000000000000");
    memory.add("1110000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testRead() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1100000000000000");
    memory.add("1100000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }

  @Test
  public void testRet() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1001000000000000");
    memory.add("1001000000000000");
    assertEquals(1, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testStop() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("1011000000000000");
    memory.add("1011000000000000");
    assertEquals(1, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testStore() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0111000000000000");
    memory.add("0111000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testSub() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0110000000000000");
    memory.add("0110000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
  @Test
  public void testWrite() {
    Operacoes operacoes = new Operacoes();
    List<String> memory = new ArrayList<String>();
    memory.add("0100000000000000");
    memory.add("0100000000000000");
    assertEquals(2, operacoes.executaOperacao(memory, 0));
  }
  
}
