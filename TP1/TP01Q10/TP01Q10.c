#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main(){
    int num, z;
    FILE *saida = fopen("texto.txt", "w");

    scanf("%d", &num);

    for (int i = 0; i < num; i++){
        double valor;
        scanf("%lf", &valor);

        fprintf(saida, "%lf\n", valor);
    }
    fseek(saida,0,SEEK_END); // 0 means don’t move anywhere, SEEK_END means move this file pointer to the end of the file.
    z = ftell(saida); //total of bytes of the file

    fclose(saida);

    saida = fopen("texto.txt", "r");

    for (int i = 8; i <= z; i += 8){
        fseek(saida,(z-i),SEEK_SET);

        double aux;
        scanf("%lf", &aux);

        if (aux % 1 == 0) {
                printf("%.0lf\n", aux); //if it happens to be an integer, convert it to int and print
            } else{
                printf("%.3lf\n", aux);
            }               
    }

    fclose(saida);


}