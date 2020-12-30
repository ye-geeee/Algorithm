def solution(phone_book):
    phone_book.sort()

    for phone1, phone2 in zip(phone_book, phone_book[1:]):
        if phone2.startswith(phone1):
            return False

    return True

if __name__ == '__main__':
    phone_book = ["12", "123", "1235", "567", "88"]
    print(solution(phone_book))