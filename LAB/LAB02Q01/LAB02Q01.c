#include <stdio.h>
#include <string.h>

void intercalaFrase(char pri[100], char seg[100]){
    char res[200];
    int tam = 0, j = 0;

    if (strlen(pri) < strlen(seg)) tam = strlen(pri);
    else tam = strlen(seg); // escolhe a menor string para ser o tamanho de referencia

    for (int i = 0; i < tam*2; i++){ // intercala ate a menor string terminar
        res[i] = pri[j];
        res[++i] = seg[j];
        j++;
    }

    if (strlen(pri) != strlen(seg)){ // se os tamanhos forem diferentes
        
        if (tam == strlen(pri)){ // tem que completar com o restante da segunda string
            for(int i = (strlen(pri) * 2); i < strlen(seg) + strlen(pri); i++){
              res[i] = seg[j];
              j++;
            }
        }
        else { // tem que completar com o restante da segunda string
            for(int i = (strlen(seg) * 2); i < strlen(seg) + strlen(pri); i++){
              res[i] = pri[j];
              j++;
            }
        }
    }
    
    res[strlen(pri) + strlen(seg)] = '\0';
    printf("%s\n", res);
}

int main (){
    char pri[100], seg[100], texto[100][100];
    int i = 0;

    while (scanf("%s", pri) != EOF){ // leitura até terminar o arquivo; %s -> le ate o espaco
        scanf("%s", seg);
        intercalaFrase(pri, seg);
    }

    return 0;
}