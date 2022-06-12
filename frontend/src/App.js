import './App.css';
import { Component } from 'react';
import CardEdit from './CardEdit';
import { Container, Table } from 'reactstrap';
class App extends Component {

  state = {
    cards: [],

  };

  async componentDidMount() {
    const response = await fetch('/getAllCards');
    const body = await response.json();
    this.setState({cards: body});
  }

  render() {
  const {cards} = this.state;
  const cardsList = cards.map(cards => {
          return <tr key={cards.id}>
          <td style={{whiteSpace: 'nowrap'}}>{cards.name}</td>
              <td style={{whiteSpace: 'nowrap'}}>{cards.cardNumber}</td>
              <td>{cards.balance}</td>
              <td>{cards.limit}</td>
          </tr>
      });

    return (
    <div>
    <div>
    <CardEdit/>
</div>
        <Container fluid>
              <h3>Existing Cards</h3>
              <Table className="mt-4">
                                  <thead>
                                  <tr>
                                      <th width="30%">Name</th>
                                      <th width="30%">Card Number</th>
                                      <th width="40%">Balance</th>
                                      <th width="40%">Limit</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  {cardsList}
                                  </tbody>
                              </Table>
            </Container>
            </div>
    );
  }
}
export default App;