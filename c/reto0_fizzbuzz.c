/*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

#include <stdio.h>

int main()
{
    int mul_3, mul_5;

    for (int i = 1; i <= 100; i++)
    {
        mul_3 = (i % 3 == 0);
        mul_5 = (i % 5 == 0);

        if (mul_3 && mul_5)
            printf("fizzbuzz\n");
        else if (mul_3)
            printf("fizz\n");
        else if (mul_5)
            printf("buzz\n");
        else
            printf("%d\n", i);
    }

    return 0;
}