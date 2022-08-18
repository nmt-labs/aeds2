#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int soVogal(char s[1000]){
    int r = 0;
    for(int i = 0 ; i < strlen(s); i++){ 
        if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
            r = 1;
        } else {
            i = strlen(s);
            r = 0;
        }     
    }
    return r;
}

int soConsoante(char s[1000]){
    int r = 0;
    for(int i = 0; i < strlen(s); i++){
        if( (int)s[i] > 64 && (int)s[i] < 91 || (int)s[i] > 96 && (int)s[i] < 123){    
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
                i = strlen(s);
                r = 0;
            } else {
                r = 1;
            }
        }
    }
    return r;
}

int ehInt(char s[1000]){
    int r = 0;
    for(int i = 0; i < strlen(s); i++){
        if ((int)s[i] > 47 && (int)s[i] < 58){
            r = 1;
        } else {
            i = strlen(s);
            r = 0;
        }
    }
    return r;
}

int ehReal(char s[1000]){
    int r = 0;
     for(int i =0; i < strlen(s); i++){
            if((int)s[i] > 47 && (int)s[i] < 58 || s[i] == 46){
                r = 1;
            } else {
                r = 0;
                i = strlen(s);
            }
        }

    return r;
}

int main(){
    char texto[1000][1000];
    int i = 0;

    do{
        //cada ler linhas seguintes
        scanf(" %[^\n]", texto[i]);

    }while (strcmp(texto[i++], "FIM") != 0);
    i--;

    //f -> frase
    //contar letras maiúsculas de cada frase
    for(int f = 0; f < i; f++){
        if(soVogal(texto[f])) printf("SIM ");
        else printf("NAO ");

        if(soConsoante(texto[f])) printf("SIM ");
        else printf("NAO ");

        if(ehInt(texto[f])) printf("SIM ");
        else printf("NAO ");

        if(ehReal(texto[f])) printf("SIM\n");
        else printf("NAO\n");
    }
}

// -----------------------------------------------------------------------
// #include <stdio.h>
// #include <stdlib.h>
// #include <stdbool.h>
// #include <string.h>
// #include <ctype.h>

// bool isFim(char s[]){
//     return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
// }

// void isVogal(char s[]){
//     bool resp = false;
//     for(int i = 0 ; i < strlen(s); i++){ 
//         if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
//             resp = true;
//         } else {
//             i = strlen(s);
//             resp = false;
//         }     
//     }
//     if (resp == false){
//         printf("NAO");
//     } else {
//         printf("SIM");
//     }
// }

// void isConsoante(char s[]){
//     bool resp  = false;
//     for(int i = 0; i < strlen(s); i++){
//         if( (int)s[i] > 64 && (int)s[i] < 91 || (int)s[i] > 96 && (int)s[i] < 123){    
//             if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'){
//                 i = strlen(s);
//                 resp = false;
//             } else {
//                 resp = true;
//             }
//         }
//         }
//     if (resp == false){
//         printf("NAO");
//     } else {
//         printf("SIM");
//     }
// }

// void isInteiro(char s[]){
//     bool resp = false;
//     for(int i = 0; i < strlen(s); i++){
//         if ((int)s[i] > 47 && (int)s[i] < 58){
//             resp = true;
//         } else {
//             i = strlen(s);
//             resp = false;
//         }
//     }

//     if (resp == true){
//         printf("SIM");
//     } else {
//         printf("NAO");
//     }
// }

// void isReal (char s[]){
//         bool resp = false;
//         for(int i =0; i < strlen(s); i++){
//             if((int)s[i] > 47 && (int)s[i] < 58 || s[i] == 46){
//                 resp = true;
//             } else {
//                 resp = false;
//                 i = strlen(s);
//             }
//         }
//         if(resp == true){
//             printf("SIM");
//         } else {
//             printf("NAO");
//         }
        
//     }



// int main(){
//     char entrada[1000][100];
//     int numEntrada = 0;

//     // Leitura da entrada padrao
//     do{
//         scanf(" %[^\n]s", entrada[numEntrada]);
//     } while (isFim(entrada[numEntrada++]) == false);
//     numEntrada--;

//     // Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
//     for (int i = 0; i < numEntrada; i++){
//         isVogal(entrada[i]);
//         printf(" ");
//         isConsoante(entrada[i]);
//         printf(" ");
//         isInteiro(entrada[i]);
//         printf(" ");
//         isReal(entrada[i]);
//         printf("\n");
//     }
//     return 0;
// }

