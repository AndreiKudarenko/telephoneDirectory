       <html>
          <head>
             <title>Simple MVC</title>
          </head>
          <body>
                 <legend>What do you want?</legend>
             <div>
                    <form method="GET" action="/subscribers/all">
                           <input type="submit" value="allSubscribers"> List of subscribers!
                    </form>
             </div>
             <div>
                    <form method="GET" action="/addSubscriber">
                           <input type="submit" value="addSubscribers"> Press to add subscribers!
                    </form>
                    <form method="GET" action="/subscribers/get">
                    <label for="id">Id:</label>
                                <input id="id" type="text" name="id">
                        <input type="submit" value="get"> Get subscriber by id!
                    </form>
              </div>
          </body>

       </html>