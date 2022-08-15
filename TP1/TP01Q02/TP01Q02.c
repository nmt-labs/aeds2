#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int isPalindromo(char texto[1000]){
    int resp = 1; //true
    int tam = strlen(texto);

    for(int i = 0 ; i < tam/2; i++){
         if(texto[i] != texto[tam-1-i]){
                resp = 0; //false
                i = tam;
            }
    }

    return resp;
}

int main(){
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
        if(isPalindromo(texto[f])) printf("SIM\n");
        else printf("NAO\n");
    }
}