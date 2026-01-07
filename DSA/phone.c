#include<stdio.h>
#include<string.h>

struct Contact {
    char name[50];
    long phone;
};

int n = 0;

/* Function to sort contacts by name */
void sort(struct Contact c[]) {
    struct Contact temp;
    for(int i = 0; i < n - 1; i++) {
        for(int j = i + 1; j < n; j++) {
            if(strcmp(c[i].name, c[j].name) > 0) {
                temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
        }
    }
}

/* Binary Search */
int binarySearch(struct Contact c[], char key[]) {
    int low = 0, high = n - 1;
    while(low <= high) {
        int mid = (low + high) / 2;
        int cmp = strcmp(c[mid].name, key);

        if(cmp == 0)
            return mid;
        else if(cmp < 0)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

int main() {
    struct Contact c[50];
    int choice;
    char searchName[50];

    while(1) {
        printf("\n1.Add Contact\n2.Display\n3.Search\n4.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch(choice) {
        case 1:
            printf("Enter name: ");
            scanf("%s", c[n].name);
            printf("Enter phone: ");
            scanf("%ld", &c[n].phone);
            n++;
            sort(c);
            break;

        case 2:
            printf("\nPhone Directory:\n");
            for(int i = 0; i < n; i++)
                printf("%s - %ld\n", c[i].name, c[i].phone);
            break;

        case 3:
            printf("Enter name to search: ");
            scanf("%s", searchName);
            int pos = binarySearch(c, searchName);
            if(pos != -1)
                printf("Found: %s - %ld\n", c[pos].name, c[pos].phone);
            else
                printf("Contact not found\n");
            break;

        case 4:
            return 0;

        default:
            printf("Invalid choice\n");
        }
    }
}