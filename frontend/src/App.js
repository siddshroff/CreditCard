import './App.css';
import { Component } from 'react';
import AppNavbar from './AppNavbar';
import { Button, Container, Form, FormGroup, Input, Label, Table } from 'reactstrap';
class App extends Component {
  state = {
    cards: [],

  };

  async componentDidMount() {
    const response = await fetch('/getAllCards');
    const body = await response.json();
    this.setState({cards: body});
  }
async handleSubmit(event) {
    event.preventDefault();


    await fetch('/addCard', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(),
    });
}
handleChange(event) {

  }
  render() {
  <AppNavbar/>
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
    <Container>
                  <h2>Credit Card System</h2>
                  <Form onSubmit={this.handleSubmit}>
                      <FormGroup>
                          <Label for="name">Name</Label>
                          <Input type="text" name="name" id="name"
                                 onChange={this.handleChange} autoComplete="name"/>
                      </FormGroup>
                      <FormGroup>
                          <Label for="cardNo">Card Number</Label>
                          <Input type="text" name="cardNo" id="cardNo"
                                 onChange={this.handleChange} autoComplete="card Number"/>
                      </FormGroup>
                      <FormGroup>
                          <Label for="limit">Limit</Label>
                          <Input type="text" name="limit" id="limit"
                                 onChange={this.handleChange} autoComplete="limit"/>
                      </FormGroup>
                      <FormGroup>
                          <Button color="primary" type="submit">Add</Button>{' '}
                      </FormGroup>
                  </Form>
              </Container>
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