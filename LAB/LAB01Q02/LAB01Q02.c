#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

//método recursivo que seleciona a frase e um caractere na posição indicada para verificar se esse caractere é maiúsculo
int contarLetrasMais(char texto[1000], int i){
    int conta = 0;
    
    //condição de parada: conta até o último caractere da frase (linha atual)
    if(i < strlen(texto)){
        //verifica se o caractere é maiusculo, retornando 1(true) ou 0(false)
        if (isupper(texto[i])) conta = 1 + contarLetrasMais(texto, (i+1));
        else conta = contarLetrasMais(texto, (i+1));
    }

    return conta;
}

int main (){
    char frase[1000], texto[1000][1000];
    int i = 0;

    do{
        //cada ler linhas seguintes
        scanf(" %[^\n]", frase);

        strcpy(texto[i], frase);
        //printf("frase: %s\n", texto[i]);
        i++;
    }while (strcmp(frase, "FIM") != 0);
    i--;

    //f -> frase
    //contar letras maiúsculas de cada frase
    for(int f = 0; f < i; f++){
        printf("%d\n", contarLetrasMais(texto[f], 0));
    }
}

//funciona mas no terminal do ubunto dá core dumped