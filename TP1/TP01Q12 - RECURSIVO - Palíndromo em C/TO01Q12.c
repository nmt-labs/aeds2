#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int isPalindromo(char texto[1000]){
    int resp = 1; //true

    if(i <= j) {
          if (texto[i] != texto[j]) resp = false;
          else resp = isPalindromo(texto, (i+1), (j-1));
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
