def add(a,b):
    return a+b

def multiply(a, b):
    return a * b

def sub(a,b):
    return a-b

opt = [add, multiply, sub]

pmt = "\nSelect an operation by number: \n1. add\n2. multiply\n3. subtract\n4. exit\n"

def main():

    while True:

        op_ind = 0;

        while True:
            op_ind = int_input(pmt)
            if op_ind < 1 or 4 < op_ind:
                print("Use a number between 1 and 4\n")
                continue
            break

        if op_ind == 4:
            print("\nBye")
            break

        a = int_input("\nFirst number")
        b = int_input("\nSecond number")

        op_ind -= 1

        print()
        print("*" * 10)
        print("Result: {}".format(opt[op_ind](a, b)))
        print("*" * 10)
        input()


def int_input(pmtin):

    while True:

        print(pmtin)
        ind = input("Enter number: ")

        try:
            ind = int(ind)
        except:
            print("Invalid input\n")
            continue

        return ind


if __name__ == "__main__":
    main()

0