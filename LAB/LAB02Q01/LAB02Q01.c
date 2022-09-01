#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void intercalaFrase(char pri[1000], char seg[1000]){
    char res[2000];
    int tam = 0, j = 0;
    

    if (strlen(pri) < strlen(seg)) tam = strlen(pri);
    else tam = strlen(seg); // escolhe a menor string para ser o tamanho de referencia

    for (int i = 0; i < tam; i++){ // intercala ate a menor string terminar
        res[i] = pri[j];
        res[i++] = seg[j];
        j++;
    }

    if (strlen(pri) != strlen(seg)){ // se os tamanhos forem diferentes
        if (tam == strlen(pri)){ // tem que completar com o restante da segunda string
            for(int i = tam; i < strlen(seg); i++){
                res[i] = seg[i];
            }
        }
        else { // tem que completar com o restante da segunda string
            for(int i = tam; i < strlen(pri); i++){
                res[i] = pri[i];
            }
        }
    }
    //erro ta aqui
    printf("%s", res);

}

int main (){
    char pri[1000], seg[1000], texto[1000][1000];
    int i = 0;

    while (scanf("%s", pri) != EOF){ // leitura até terminar o arquivo; %s -> le ate o espaco
        scanf("%s", seg);
        //printf("pri: %s; seg: %s\n", pri, seg);
        intercalaFrase(pri, seg);
    }

    return 0;
}