# 🧾 Java – Manipulação de Listas e Estruturas de Dados

Este documento resume conceitos importantes sobre manipulação de listas (`ArrayList`) em Java, com foco em remoção de elementos durante a iteração e a relação com a exceção `ConcurrentModificationException`.

---

## ⚠️ `ConcurrentModificationException` em `ArrayList`

### Por que acontece?

Essa exceção ocorre quando modificamos uma lista (`ArrayList`) enquanto a percorremos com um **`Iterator`** (usado implicitamente em `for-each`). Isso é uma **decisão da linguagem Java** para proteger contra inconsistências na iteração. Como no exemplo comentado na função de remoção da Classe **CarrinhoDeCompras**:
```java
    public void removerItem(String nome) {
        List<Item> itensRemover = new ArrayList<>();
        for(Item i : listItens) {
            if(i.getNome().equalsIgnoreCase(nome)) {
                //itensRemover.add(i); --> Solução esperada
                listItens.remove(i); // --> ConcurrentModificationException
            }
        }
        //listItens.removeAll(itensRemover);
    }

```

### O que está por trás?

- A classe `ArrayList` possui um campo interno `modCount`, que conta alterações estruturais (como `.add()` ou `.remove()`).
- Quando o `Iterator` é criado, ele grava o valor atual de `modCount`.
- Se você modificar a lista diretamente (sem o `Iterator`) durante a iteração, esse valor muda e o Java lança a exceção para **falhar rapidamente** (*fail-fast*), evitando comportamento inesperado.

### Soluções seguras

- **Usar `Iterator.remove()`**:
  ```java
  Iterator<Item> it = listItens.iterator();
  while (it.hasNext()) {
      if (it.next().getNome().equalsIgnoreCase(nome)) {
          it.remove(); // seguro
      }
  }
  ```

- **Usar `removeIf` (Java 8+)**:
  ```java
  listItens.removeIf(i -> i.getNome().equalsIgnoreCase(nome));
  ```

---

## 🧠 Características da `ArrayList` que causam o problema

- Baseada em array interno contínuo.
- Quando um item é removido, os elementos seguintes **são todos deslocados para a esquerda**, reindexando a lista.
- Isso causa **confusão em loops `for` tradicionais**, especialmente ao remover itens durante a iteração.

---

## 🧪 Por que o `for` tradicional pode falhar ao remover elementos

Ao usar:

```java
for (int i = 0; i < list.size(); i++) {
    if (list.get(i).equals("banana")) {
        list.remove(i);
    }
}
```

Em uma lista como `["banana", "banana", "banana"]`, após remover o item do índice `0`, os elementos se deslocam e a segunda `"banana"` pula para o índice `0`, mas o `for` avança para `i = 1`, **pulando essa nova posição**. Resultado: **uma "banana" pode sobrar na lista**.

### ✅ Solução: percorrer de trás para frente

```java
for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i).equals("banana")) {
        list.remove(i);
    }
}
```

Assim, os elementos ainda a serem verificados **não se deslocam** com a remoção.

---

## ✅ Conclusão

| Tema                          | Abordagem Segura                                   |
|------------------------------|-----------------------------------------------------|
| Remoção durante iteração     | Use `Iterator.remove()` ou `removeIf()`             |
| Evitar `ConcurrentModificationException` | Nunca altere diretamente dentro de um `for-each` |
| `for` tradicional com remoção | Prefira percorrer a lista de trás para frente      |
| Comportamento da `ArrayList` | Alterações estruturais deslocam elementos e mudam índices |

---

