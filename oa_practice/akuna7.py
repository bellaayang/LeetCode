class OrderBook:
    def __init__(self, mm_bid, mm_bid_size, mm_ask, mm_ask_size, lot_size):
        self.mm_bid = mm_bid
        self.mm_bid_size = mm_bid_size
        self.mm_ask = mm_ask
        self.mm_ask_size = mm_ask_size
        self.lot_size = lot_size
        self.orders = {}

    def add(self, orderId, ts, isbid, price, qty):
        # 判断合格 → 存进 self.orders
        # 返回 self.best()
        if qty % self.lot_size == 0:
           if isbid:
               if price > self.mm_bid or (price == self.mm_bid and qty > self.mm_bid_size * 0.05):
                   self.orders[orderId] = (isbid, price, qty)
           else:
               if price < self.mm_ask or (price == self.mm_ask and qty > self.mm_ask_size * 0.05):
                   self.orders[orderId] = (isbid, price, qty)
        return self.best()
               

        

    def cancel(self, orderId, ts):
        # 从 self.orders 删掉
        # 返回 self.best()
        if orderId in self.orders:
            self.orders.pop(orderId)
        return self.best()

    def best(self):
        # 扫一遍 self.orders，算出 (best_bid, best_ask)
        best_bid = self.mm_bid
        best_ask = self.mm_ask
        for isbid, price, qty in self.orders.values():
            if isbid:
                if price > best_bid:
                    best_bid = price
            else:
                if price < best_ask:
                    best_ask = price
        return best_bid, best_ask
book = OrderBook(100, 1000, 101, 1000, 100)
print(book.add(1, 0, True, 100.5, 200))   # (100.5, 101)
print(book.add(2, 1, False, 100.8, 40))   # (100.5, 101)
print(book.add(3, 2, False, 100.8, 300))  # (100.5, 100.8)
print(book.add(4, 3, True, 99, 100))      # (100.5, 100.8)
print(book.cancel(1, 4))                  # (100, 100.8)  