package Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Compilador extends javax.swing.JFrame {

    List<String> cadenas = new ArrayList<String>();
    List<String> enteros = new ArrayList<String>();
    List<String> reales = new ArrayList<String>();
    List<String> vcadenas = new ArrayList<String>();
    List<String> venteros = new ArrayList<String>();
    List<String> vreales = new ArrayList<String>();
    String[] tipo = {"cadena", "entero", "real"};
    int numLinea = 0, error = 0, numLineaa = 0;
    tripleta tr = new tripleta();
    String lineaCod[];

    public Compilador() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void ValidarTipo(String TipoVariable[]) {
        if (TipoVariable[0].equals(tipo[0])) {
            NomVariableCadena(TipoVariable[1]);
        } else if (TipoVariable[0].equals(tipo[1])) {
            NomVariableEntero(TipoVariable[1]);
        } else if (TipoVariable[0].equals(tipo[2])) {
            NomVariableReal(TipoVariable[1]);
        } else {
            errores.setText(errores.getText() + "Error[2]: No reconoce el tipo de dato. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public void NomVariableCadena(String nombre) {
        if (nombre.matches("^[A-Za-z]{1,}$")) {
            if (cadenas.isEmpty()) {
                boolean existe2 = enteros.contains(nombre);
                boolean existe3 = reales.contains(nombre);
                if (existe2 || existe3) {
                    errores.setText(errores.getText() + "Error[4]: Coloque un nombre de variable que no se repita. En la linea " + (numLinea + 1) + "\n");
                    error++;
                } else {
                    cadenas.add(nombre);
                    int p = cadenas.indexOf(nombre);
                    vcadenas.add(p, " ");
                    errores.setText(errores.getText() + "La declaración es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            } else {
                boolean existe1 = cadenas.contains(nombre);
                boolean existe2 = enteros.contains(nombre);
                boolean existe3 = reales.contains(nombre);
                if (existe1 || existe2 || existe3) {
                    errores.setText(errores.getText() + "Error[4]: Coloque un nombre de variable que no se repita. En la linea " + (numLinea + 1) + "\n");
                    error++;
                } else {
                    cadenas.add(nombre);
                    int p = cadenas.indexOf(nombre);
                    vcadenas.add(p, " ");
                    errores.setText(errores.getText() + "La declaración es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            }
        } else {
            errores.setText(errores.getText() + "Error[3]: Coloque un nombre de variable correcto. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public void NomVariableEntero(String nombre) {
        if (nombre.matches("^[A-Za-z]{1,}$")) {
            if (enteros.isEmpty()) {
                boolean existe2 = cadenas.contains(nombre);
                boolean existe3 = reales.contains(nombre);
                if (existe2 || existe3) {
                    errores.setText(errores.getText() + "Error[4]: Coloque un nombre de variable que no se repita. En la linea " + (numLinea + 1) + "\n");
                    error++;
                } else {
                    enteros.add(nombre);
                    int p = enteros.indexOf(nombre);
                    venteros.add(p, 0 + "");
                    errores.setText(errores.getText() + "La declaración es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            } else {
                boolean existe1 = cadenas.contains(nombre);
                boolean existe2 = enteros.contains(nombre);
                boolean existe3 = reales.contains(nombre);
                if (existe1 || existe2 || existe3) {
                    errores.setText(errores.getText() + "Error[4]: Coloque un nombre de variable que no se repita. En la linea " + (numLinea + 1) + "\n");
                    error++;
                } else {
                    enteros.add(nombre);
                    int p = enteros.indexOf(nombre);
                    venteros.add(p, 0 + "");
                    errores.setText(errores.getText() + "La declaración es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            }
        } else {
            errores.setText(errores.getText() + "Error[3]: Coloque un nombre de variable correcto. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public void NomVariableReal(String nombre) {
        if (nombre.matches("^[A-Za-z]{1,}$")) {
            if (reales.isEmpty()) {
                boolean existe2 = enteros.contains(nombre);
                boolean existe3 = cadenas.contains(nombre);
                if (existe2 || existe3) {
                    errores.setText(errores.getText() + "Error[4]: Coloque un nombre de variable que no se repita. En la linea " + (numLinea + 1) + "\n");
                    error++;
                } else {
                    reales.add(nombre);
                    int p = reales.indexOf(nombre);
                    vreales.add(p, 0 + "");
                    errores.setText(errores.getText() + "La declaración es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            } else {
                boolean existe1 = cadenas.contains(nombre);
                boolean existe2 = enteros.contains(nombre);
                boolean existe3 = reales.contains(nombre);
                if (existe1 || existe2 || existe3) {
                    errores.setText(errores.getText() + "Error[4]: Coloque un nombre de variable que no se repita. En la linea " + (numLinea + 1) + "\n");
                    error++;
                } else {
                    reales.add(nombre);
                    int p = reales.indexOf(nombre);
                    vreales.add(p, 0 + "");
                    errores.setText(errores.getText() + "La declaración es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            }
        } else {
            errores.setText(errores.getText() + "Error[3]: Coloque un nombre de variable correcto. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public static String operEspacio(String cadena) {
        String valor = "";
        String cadS[] = cadena.split("");
        for (int i = 0; i < cadS.length; i++) {
            if (cadS[i].matches("^([0-9]|\\.){1,}$") || cadS[i].matches("^[a-zA-Z]{1,}$")) {
                valor += cadS[i];
            } else {
                valor = valor + " " + cadS[i] + " ";
            }
        }
        return valor;
    }

    public void AsignarValor(String[] valor) {
        boolean existe1 = cadenas.contains(valor[0]);
        boolean existe2 = enteros.contains(valor[0]);
        boolean existe3 = reales.contains(valor[0]);
        int p = 0;
        if (existe1) {
            String suma[] = valor[1].split("\\+");
            if (suma.length == 2) {
                OpString(suma[0], suma[1], valor[0]);
            } else if (valor[1].matches("^\"[A-Za-z0-9]{1,}\"$")) {
                String val[] = valor[1].split("\"");
                p = cadenas.indexOf(valor[0]);
                String vll = vcadenas.get(p);
                if (vll.contains(" ")) {
                    vcadenas.add(p, val[1]);
                    errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
                } else {
                    vcadenas.set(p, val[1]);
                    errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
                }
            } else {
                errores.setText(errores.getText() + "Error[6]:El valor del dato no es correcto. En la linea " + (numLinea + 1) + "\n");
                error++;
            }
        } else if (existe2) {
            String arit = operEspacio(valor[1]);
            if (valor[1].length() == arit.length()) {
                if (valor[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(valor[0]);
                    String ve = venteros.get(p);
                    if (ve.contains("0")) {
                        venteros.add(p, valor[1]);
                        errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        venteros.set(p, valor[1]);
                        errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
                    }
                } else {
                    errores.setText(errores.getText() + "Error[6]:El valor del dato no es correcto. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (valor[1].length() != arit.length()) {
                ResulEntero(valor[0], arit);
            } else {
                errores.setText(errores.getText() + "Error[6]:El valor del dato no es correcto. En la linea " + (numLinea + 1) + "\n");
                error++;
            }
        } else if (existe3) {
            String ari = operEspacio(valor[1]);
            if (valor[1].length() == ari.length()) {
                if (valor[1].matches("^[0-9]{1,}\\.[0-9]{1,}$")) {
                    p = reales.indexOf(valor[0]);
                    String vr = vreales.get(p);
                    if (vr.contains("0")) {
                        vreales.add(p, valor[1]);
                        errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        vreales.set(p, valor[1]);
                        errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
                    }
                } else {
                    errores.setText(errores.getText() + "Error[6]:El valor del dato no es correcto. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (valor[1].length() != ari.length()) {
                ResulReal(valor[0], ari);
            } else {
                errores.setText(errores.getText() + "Error[6]:El valor del dato no es correcto. En la linea " + (numLinea + 1) + "\n");
                error++;
            }
        } else {
            errores.setText(errores.getText() + "Error[5]:Variable no declarada. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public void ResulEntero(String variable, String arit) {
        String valores[] = arit.split(" ");
        int err = 0, p = 0;
        String post = "";
        boolean ex1, ex2;
        Stack<String> pilav = new Stack<String>();
        for (int i = 0; i < valores.length; i++) {
            if (valores[i].matches("^[A-Za-z]{1,}$")) {
                ex1 = enteros.contains(valores[i]);
                ex2 = reales.contains(valores[i]);
                if (ex1) {
                    p = enteros.indexOf(valores[i]);
                    String valor = venteros.get(p);
                    valores[i] = valor;
                } else if (ex2) {
                    p = reales.indexOf(valores[i]);
                    String valor = vreales.get(p);
                    valores[i] = valor;
                } else {
                    err++;
                }
            }
        }
        //juntar cadenas con valores
        if (err == 0) {
            for (int i = 0; i < valores.length; i++) {
                post = post + " " + valores[i];
            }
            //post
            String a = infixToPostfix(post);
            //mandar a operaciones
            String Pa[] = a.split(" ");
            tr.Mpost("Operación: " + variable + " = " + post);
            tr.Mpost("Postfija: " + a + " " + variable + " =");
            for (int i = 0; i < Pa.length; i++) {
                if (Pa[i].matches("^[0-9]{1,}$") || Pa[i].matches("^[0-9]{1,}\\.[0-9]{1,}$")) {
                    pilav.push(Pa[i]);
                } else if (Pa[i].matches("^[*|+|\\-|/|\\^]{1,}$")) {
                    String v2 = pilav.pop();
                    String v1 = pilav.pop();
                    String nuevo = OpAE(Pa[i], v1, v2);
                    pilav.push(nuevo);
                    tr.agregar(Pa[i], v1, v2);
                } else {
                    errores.setText(errores.getText() + "Error[5-6]:Variable no declarada o tipo incorrecto. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            }
            p = enteros.indexOf(variable);
            String result = pilav.pop();
            venteros.set(p, result);
            tr.agregar("=", variable, result);
            errores.setText(errores.getText() + "La operación es correcta. En la linea " + (numLinea + 1) + "\n");
        } else {
            errores.setText(errores.getText() + "Error[5-6]:Variable no declarada o tipo incorrecto. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public String OpAE(String op, String v1, String v2) {
        String resul = "";
        int oper = 0;
        int va1 = Integer.parseInt(v1);
        int va2 = Integer.parseInt(v2);
        switch (op) {
            case "+":
                oper = va1 + va2;
                break;
            case "-":
                oper = va1 - va2;
                break;
            case "*":
                oper = va1 * va2;
                break;
            case "/":
                oper = va1 / va2;
                break;
            case "^":
                oper = (int) Math.pow(va1, va2);
                break;
            default:
                errores.setText(errores.getText() + "Error[5-6]:Variable no declarada. En la linea " + (numLinea + 1) + "\n");
                error++;
                break;
        }
        return resul + oper;
    }

    public void ResulReal(String variable, String arit) {
        String valores[] = arit.split(" ");
        int err = 0, p = 0;
        String post = "";
        boolean ex1, ex2;
        Stack<String> pilav = new Stack<String>();
        for (int i = 0; i < valores.length; i++) {
            if (valores[i].matches("^[A-Za-z]{1,}$")) {
                ex1 = enteros.contains(valores[i]);
                ex2 = reales.contains(valores[i]);
                if (ex1) {
                    p = enteros.indexOf(valores[i]);
                    String valor = venteros.get(p);
                    valores[i] = valor;
                } else if (ex2) {
                    p = reales.indexOf(valores[i]);
                    String valor = vreales.get(p);
                    valores[i] = valor;
                } else {
                    err++;
                }
            }
        }
        if (err == 0) {
            for (int i = 0; i < valores.length; i++) {
                post = post + " " + valores[i];
            }
            String a = infixToPostfix(post);
            //mandar a operaciones
            String Pa[] = a.split(" ");
            tr.Mpost("Operación: " + variable + " = " + post);
            tr.Mpost("Postfija: " + a + " " + variable + " =");
            for (int i = 0; i < Pa.length; i++) {
                if (Pa[i].matches("^[0-9]{1,}$") || Pa[i].matches("^[0-9]{1,}\\.[0-9]{1,}$")) {
                    pilav.push(Pa[i]);
                } else if (Pa[i].matches("^[*|+|\\-|/|\\^]{1,}$")) {
                    String v2 = pilav.pop();
                    String v1 = pilav.pop();
                    String nuevo = OpR(Pa[i], v1, v2);
                    pilav.push(nuevo);
                    tr.agregar(Pa[i], v1, v2);
                } else {
                    errores.setText(errores.getText() + "Error[5-6]:Variable no declarada o tipo incorrecto. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            }
            p = reales.indexOf(variable);
            String result = pilav.pop();
            vreales.set(p, result);
            tr.agregar("=", variable, result);
            errores.setText(errores.getText() + "La operación es correcta. En la linea " + (numLinea + 1) + "\n");
        } else {
            errores.setText(errores.getText() + "Error[5-6]:Variable no declarada o tipo incorrecto. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public String OpR(String op, String v1, String v2) {
        String resul = "";
        double oper = 0;
        double va1 = Double.parseDouble(v1);
        double va2 = Double.parseDouble(v2);
        switch (op) {
            case "+":
                oper = va1 + va2;
                break;
            case "-":
                oper = va1 - va2;
                break;
            case "*":
                oper = va1 * va2;
                break;
            case "/":
                oper = va1 / va2;
                break;
            case "^":
                oper = Math.pow(va1, va2);
                break;
            default:
                errores.setText(errores.getText() + "Error[5-6]:Variable no declarada. En la linea " + (numLinea + 1) + "\n");
                error++;
                break;
        }
        return resul + oper;
    }

    static String infixToPostfix(String infix) {
        /* Para averiguar la precedencia, tomamos el índice del token en la cadena de operaciones y dividir por 2 (redondeando hacia abajo).
        Esto nos dará: 0, 0, 1, 1, 2 */
        final String ops = "-+/*^";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        for (String token : infix.split("\\s")) {
            if (token.isEmpty()) {
                continue;
            }
            char c = token.charAt(0);
            int idx = ops.indexOf(c);
            // buscar operador
            if (idx != -1) {
                if (s.isEmpty()) {
                    s.push(idx);
                } else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^')) {
                            sb.append(ops.charAt(s.pop())).append(' ');
                        } else {
                            break;
                        }
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2); // -2 significa '('
            } else if (c == ')') {
                // Hasta '(' en la pila, operadores pop.
                while (s.peek() != -2) {
                    sb.append(ops.charAt(s.pop())).append(' ');
                }
                s.pop();
            } else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty()) {
            sb.append(ops.charAt(s.pop())).append(' ');
        }
        return sb.toString();
    }

    public void OpString(String v1, String v2, String elem) {
        int p = 0;
        boolean exist1, exist2;
        exist1 = cadenas.contains(v1);
        exist2 = cadenas.contains(v2);
        if (exist1 && exist2) {
            String val = vcadenas.get(cadenas.indexOf(v1)) + " " + vcadenas.get(cadenas.indexOf(v2));
            p = cadenas.indexOf(elem);
            vcadenas.set(p, val);
            errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
        } else if (exist1 && v2.matches("^\"[A-Za-z0-9]{1,}\"$")) {
            String c1[] = v2.split("\"");
            String val = vcadenas.get(cadenas.indexOf(v1)) + " " + c1[1];
            p = cadenas.indexOf(elem);
            vcadenas.set(p, val);
            errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
        } else if (exist2 && v1.matches("^\"[A-Za-z0-9]{1,}\"$")) {
            String c1[] = v1.split("\"");
            String val = c1[1] + " " + vcadenas.get(cadenas.indexOf(v2));
            p = cadenas.indexOf(elem);
            vcadenas.set(p, val);
            errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
        } else if (v1.matches("^\"[A-Za-z0-9]{1,}\"$") && v2.matches("^\"[A-Za-z0-9]{1,}\"$")) {
            String c1[] = v1.split("\"");
            String c2[] = v2.split("\"");
            String val = c1[1] + " " + c2[1];
            p = cadenas.indexOf(elem);
            vcadenas.set(p, val);
            errores.setText(errores.getText() + "El valor del dato es correcto. En la linea " + (numLinea + 1) + "\n");
        } else {
            errores.setText(errores.getText() + "Error[7]:Los valores no se reconocen del mismo tipo de dato. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    public void escribir(String salida) {
        String text[] = salida.split("\"");
        String variable[] = salida.split(",");
        boolean e1 = false, e2 = false, e3 = false;
        if (error == 0) {
            if (variable.length == 2) {
                e1 = cadenas.contains(variable[1]);
                e2 = enteros.contains(variable[1]);
                e3 = reales.contains(variable[1]);
            }
            int p = 0;
            if (text.length == 2) {
                errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                imprime.setText(imprime.getText() + "" + text[1] + "\n");
            } else if (e1) {
                p = cadenas.indexOf(variable[1]);
                errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                imprime.setText(imprime.getText() + "" + text[1] + " " + vcadenas.get(p) + "\n");
            } else if (e2) {
                p = enteros.indexOf(variable[1]);
                errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                imprime.setText(imprime.getText() + "" + text[1] + " " + venteros.get(p) + "\n");
            } else if (e3) {
                p = reales.indexOf(variable[1]);
                errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                imprime.setText(imprime.getText() + "" + text[1] + " " + vreales.get(p) + "\n");
            } else if (salida.matches("^[A-Za-z]{1,}$")) {
                boolean e11 = cadenas.contains(salida);
                boolean e22 = enteros.contains(salida);
                boolean e33 = reales.contains(salida);
                if (e11) {
                    p = cadenas.indexOf(salida);
                    errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                    imprime.setText(imprime.getText() + "" + vcadenas.get(p) + "\n");
                } else if (e22) {
                    p = enteros.indexOf(salida);
                    errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                    imprime.setText(imprime.getText() + "" + venteros.get(p) + "\n");
                } else if (e33) {
                    p = reales.indexOf(salida);
                    errores.setText(errores.getText() + "Salida correcta. En la linea " + (numLinea + 1) + "\n");
                    imprime.setText(imprime.getText() + "" + vreales.get(p) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[3]: Coloque un nombre de variable correcto. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else {
                errores.setText(errores.getText() + "Error[12]:No reconoce la estructura de imprimir. En la linea " + (numLinea + 1) + "\n");
                error++;
            }
        } else {
            imprime.setText("Corrija sus errores!!!!");
        }
    }

    //Prueba
    public void CicloM(String comparacion) {
        String igual[] = comparacion.split("\\===");
        String diferente[] = comparacion.split("\\<>");
        String mayor[] = comparacion.split("\\>");
        String menor[] = comparacion.split("\\<");
        String maigual[] = comparacion.split("\\>>==");
        String meigual[] = comparacion.split("\\<<==");
        //For
        boolean v = false;
        int i = numLinea + 1;
        for (int a = i; a < lineaCod.length; a++) {
            char cierre = lineaCod[a].charAt(lineaCod[a].length() - 1);
            if (cierre == '}') {
                numLineaa++;
                v = true;
                break;
            } else {
                numLineaa++;
            }
        }
        boolean va1 = false, va2 = false, ok = true;
        int p = 0, pp = 0, v1 = 0, v2 = 0;
        if (v) {
            if (igual.length == 2) {
                va1 = enteros.contains(igual[0]);
                va2 = enteros.contains(igual[1]);
                if (va1 && va2) {
                    p = enteros.indexOf(igual[0]);
                    pp = enteros.indexOf(igual[1]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va1 && igual[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(igual[0]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(igual[1]);
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va2 && igual[0].matches("^[0-9]{1,}$")) {
                    pp = enteros.indexOf(igual[1]);
                    v1 = Integer.parseInt(igual[0]);
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                    ok = false;
                }
                if (ok) {
                    if (v1 == v2) {
                        errores.setText(errores.getText() + "Comparación correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        numLinea = numLinea + numLineaa;
                    }
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (diferente.length == 2) {
                va1 = enteros.contains(diferente[0]);
                va2 = enteros.contains(diferente[1]);
                if (va1 && va2) {
                    p = enteros.indexOf(diferente[0]);
                    pp = enteros.indexOf(diferente[1]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va1 && diferente[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(diferente[0]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(diferente[1]);
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va2 && diferente[0].matches("^[0-9]{1,}$")) {
                    pp = enteros.indexOf(diferente[1]);
                    v1 = Integer.parseInt(diferente[0]);
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                    ok = false;
                }
                if (ok) {
                    if (v1 != v2) {
                        errores.setText(errores.getText() + "Comparación correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        numLinea = numLinea + numLineaa;
                    }
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (mayor.length == 2) {
                va1 = enteros.contains(mayor[0]);
                va2 = enteros.contains(mayor[1]);
                if (va1 && va2) {
                    p = enteros.indexOf(mayor[0]);
                    pp = enteros.indexOf(mayor[1]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va1 && mayor[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(mayor[0]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(mayor[1]);
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va2 && mayor[0].matches("^[0-9]{1,}$")) {
                    pp = enteros.indexOf(mayor[1]);
                    v1 = Integer.parseInt(mayor[0]);
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                    ok = false;
                }
                if (ok) {
                    if (v1 > v2) {
                        errores.setText(errores.getText() + "Comparación correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        numLinea = numLinea + numLineaa;
                    }
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (menor.length == 2) {
                va1 = enteros.contains(menor[0]);
                va2 = enteros.contains(menor[1]);
                if (va1 && va2) {
                    p = enteros.indexOf(menor[0]);
                    pp = enteros.indexOf(menor[1]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va1 && menor[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(menor[0]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(menor[1]);
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va2 && menor[0].matches("^[0-9]{1,}$")) {
                    pp = enteros.indexOf(menor[1]);
                    v1 = Integer.parseInt(menor[0]);
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                    ok = false;
                }
                if (ok) {
                    if (v1 < v2) {
                        errores.setText(errores.getText() + "Comparación correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        numLinea = numLinea + numLineaa;
                    }
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (maigual.length == 2) {
                va1 = enteros.contains(maigual[0]);
                va2 = enteros.contains(maigual[1]);
                if (va1 && va2) {
                    p = enteros.indexOf(maigual[0]);
                    pp = enteros.indexOf(maigual[1]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va1 && maigual[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(maigual[0]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(maigual[1]);
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va2 && mayor[0].matches("^[0-9]{1,}$")) {
                    pp = enteros.indexOf(maigual[1]);
                    v1 = Integer.parseInt(maigual[0]);
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                    ok = false;
                }
                if (ok) {
                    if (v1 >= v2) {
                        errores.setText(errores.getText() + "Comparación correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        numLinea = numLinea + numLineaa;
                    }
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else if (meigual.length == 2) {
                va1 = enteros.contains(meigual[0]);
                va2 = enteros.contains(meigual[1]);
                if (va1 && va2) {
                    p = enteros.indexOf(meigual[0]);
                    pp = enteros.indexOf(meigual[1]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va1 && meigual[1].matches("^[0-9]{1,}$")) {
                    p = enteros.indexOf(meigual[0]);
                    v1 = Integer.parseInt(venteros.get(p));
                    v2 = Integer.parseInt(meigual[1]);
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else if (va2 && meigual[0].matches("^[0-9]{1,}$")) {
                    pp = enteros.indexOf(meigual[1]);
                    v1 = Integer.parseInt(meigual[0]);
                    v2 = Integer.parseInt(venteros.get(pp));
                    errores.setText(errores.getText() + "Estructura correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                    ok = false;
                }
                if (ok) {
                    if (v1 <= v2) {
                        errores.setText(errores.getText() + "Comparación correcta del ciclo. En la linea " + (numLinea + 1) + "\n");
                    } else {
                        numLinea = numLinea + numLineaa;
                    }
                } else {
                    errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
            } else {
                errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
                error++;
            }
        } else {
            errores.setText(errores.getText() + "Error[11]: No reconcoce la variable o la estructura del ciclo. En la linea " + (numLinea + 1) + "\n");
            error++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Brun = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        errores = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        imprime = new javax.swing.JTextArea();
        tripleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");

        jLabel1.setText("Escriba aqui el código:");

        jLabel2.setText("Compilador");

        jLabel3.setText("Panel de Errores");

        jLabel4.setText("Consola");

        Brun.setText("RUN");
        Brun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrunActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        codigo.setColumns(20);
        codigo.setRows(5);
        jScrollPane1.setViewportView(codigo);

        errores.setColumns(20);
        errores.setRows(5);
        jScrollPane2.setViewportView(errores);

        imprime.setColumns(20);
        imprime.setRows(5);
        jScrollPane3.setViewportView(imprime);

        tripleta.setText("TAC");
        tripleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tripletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(139, 139, 139))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(Brun)
                        .addGap(66, 66, 66)
                        .addComponent(limpiar)
                        .addGap(43, 43, 43)
                        .addComponent(tripleta)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel2)
                .addGap(0, 363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar)
                    .addComponent(Brun)
                    .addComponent(tripleta))
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrunActionPerformed
        String texto = codigo.getText();
        lineaCod = texto.split("\n");
        errores.setText("");
        imprime.setText("");
        numLinea = 0;
        if (!lineaCod[0].equals("")) {
            do {
                char pyc = lineaCod[numLinea].charAt(lineaCod[numLinea].length() - 1);
                char pyc1 = ';';
                if (pyc == pyc1 || pyc == '{') {
                    String renglon[] = lineaCod[numLinea].split(";");
                    //linea ciclo
                    String renc[] = lineaCod[numLinea].split("\\{");
                    if (renglon.length == 1 || renc.length == 1) {
                        //validar tipo y nombre
                        String espacio[] = renglon[0].split(" ");
                        if (espacio.length == 2) {
                            ValidarTipo(espacio);
                        } else {
                            //Variable o Ciclo
                            String variable[] = renglon[0].split("=");
                            String paren[] = renglon[0].split("\\(");
                            if (variable.length == 2) {
                                AsignarValor(variable);
                            } else if (paren.length == 2) {
                                if (paren[0].equals("Mientras")) {
                                    //ajuste
                                    String comparar[] = paren[1].split("\\)");
                                    CicloM(comparar[0]);
                                } else if (paren[0].equals("Escribir")) {
                                    String escribe[] = paren[1].split("\\)");
                                    escribir(escribe[0]);
                                } else {
                                    errores.setText(errores.getText() + "Error[9]:No reconoce el token. En la linea " + (numLinea + 1) + "\n");
                                    error++;
                                }
                            } else {
                                errores.setText(errores.getText() + "Error[1]:Verifique los espacio en la cadena. En la linea " + (numLinea + 1) + "\n");
                                error++;
                            }
                        }
                    } else {
                        errores.setText(errores.getText() + "Error[0]:Punto y Coma ;. En la linea " + (numLinea + 1) + "\n");
                        error++;
                    }
                    //nuevo
                } else if (pyc == '}') {
                    errores.setText(errores.getText() + "Cierre de ciclo. En la linea " + (numLinea + 1) + "\n");
                    numLinea = numLinea - (numLineaa + 1);
                    numLineaa = 0;
                } else {
                    errores.setText(errores.getText() + "Error[0]:Punto y Coma ;. En la linea " + (numLinea + 1) + "\n");
                    error++;
                }
                numLinea++;
            } while (numLinea < lineaCod.length);
            enteros.clear();
            reales.clear();
            cadenas.clear();
            venteros.clear();
            vreales.clear();
            vcadenas.clear();
            error = 0;
            numLineaa = 0;
        } else {
            errores.setText(errores.getText() + "No hay código\n");
        }
    }//GEN-LAST:event_BrunActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        codigo.setText("");
        errores.setText("");
        imprime.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void tripletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tripletaActionPerformed

        tr.setVisible(true);
    }//GEN-LAST:event_tripletaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Brun;
    private javax.swing.JTextArea codigo;
    private javax.swing.JTextArea errores;
    private javax.swing.JTextArea imprime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton tripleta;
    // End of variables declaration//GEN-END:variables
}
